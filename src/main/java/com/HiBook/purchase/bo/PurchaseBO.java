package com.HiBook.purchase.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HiBook.cart.bo.CartBO;
import com.HiBook.cart.model.Cart;
import com.HiBook.order.bo.OrderBO;
import com.HiBook.orderproduct.bo.OrderproductBO;
import com.HiBook.orderproduct.model.Orderproduct;
import com.HiBook.product.bo.ProductBO;
import com.HiBook.product.model.Product;

@Service
public class PurchaseBO {

	@Autowired
	private ProductBO productBO;
	@Autowired
	private CartBO cartBO;
	@Autowired
	private OrderproductBO orderproductBO;
	@Autowired
	private OrderBO orderBO;

	// cart, product insert (장바구니 추가)
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
	
	// cart, product delete (장바구니 삭제)
	@Transactional
	public void deleteCartANDProductBYProductIdUserId(Integer productId, Integer userId) {

		// cart delete
		cartBO.deleteCartBYProductIdUserId(productId, userId);
		// 상품 delete
		productBO.deleteProudctById(productId);

	}
	
	//cart 수량, 가격 update (장바구니 변경)
	public void updateCartByCount(Integer productId, Integer count, Integer price, Integer userId) {

		price = price * count;
		cartBO.updateCartByCountProductIdUserId(productId, count, price, userId);

	}
	
	// cart -> orderproduct insert
	@Transactional
	public void addOrderProductAndOrderByProductIdUserId( List<Integer> productId, Integer userId) {
		
		
		Integer productid = 0;
		for (int i = 0; i < productId.size(); i++) {
			productid = productId.get(i);

			// orderProudct insert - cart의  price, count 필요
			List<Cart> cartList = cartBO.getCartListByProductIdUserId(productid, userId);
			for (Cart cart : cartList) {
				// orderproduct insert
				orderproductBO.addOrderProductByProductIdCountPriceUserId(productid, cart.getCount(), cart.getPrice(), userId);
				
				//order insert - productid, userId, cart- count, price ,  state(주문완료)
				orderBO.addOrderByProductIdUserIdOrderproductIdCountPriceState(productid, userId, cart.getCount(), cart.getPrice());
				}
			
		}
		
		
		
	}
	

}
