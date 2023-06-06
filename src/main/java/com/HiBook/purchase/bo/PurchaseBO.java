package com.HiBook.purchase.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HiBook.cart.bo.CartBO;
import com.HiBook.cart.model.Cart;
import com.HiBook.product.bo.ProductBO;
import com.HiBook.product.model.Product;

@Service
public class PurchaseBO {

	@Autowired
	private ProductBO productBO;
	@Autowired
	private CartBO cartBO;

	// 장바구니, 상품 insert
	@Transactional
	public void addcartAndProductByCountIsbn13TitlePriceUserId(Integer count, Product product, Integer userId) {

		// 상품 insert
		List<Product> productList = productBO.getProductAllList();
		int i = -1;
		
		for (Product pr : productList) {
			if(product.getIsbn13().equals(pr.getIsbn13())) { // 같으면 1 반환
				i = 1;
				Cart cart = cartBO.getCartByProductId(pr.getId());
				Integer addCount = cart.getCount() + count;
				updateCartByCount(pr.getId(), addCount , pr.getPrice(), userId);
			}
		}
		// cart insert
		if (i == -1) {
			productBO.addProductByIsbn13(product);
			cartBO.addCartByProductIdUserIdCountPrice(product.getId(), userId, count, product.getPrice());
			
		}
		//Cart cart = cartBO.getCartByProductId(product.getId());


	}
	
	

	public void deleteCartANDProductBYProductIdUserId(Integer productId, Integer userId) {

		// cart delete
		cartBO.deleteCartBYProductIdUserId(productId, userId);
		// 상품 delete
		productBO.deleteProudctById(productId);

	}

	public void updateCartByCount(Integer productId, Integer count, Integer price, Integer userId) {

		price = price * count;
		cartBO.updateCartByCountProductIdUserId(productId, count, price, userId);

	}

}
