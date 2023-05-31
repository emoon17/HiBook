package com.HiBook.purchase.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HiBook.cart.bo.CartBO;
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
	public void addcartAndProductByCountIsbn13TitlePriceUserId(
			Integer count,
			Product product,
			Integer userId){
		
		// 상품 insert
		
		productBO.addProductByIsbn13(product);
		// cart insert
		cartBO.addCartByProductIdUserIdCountPrice(product.getId(), userId, count, product.getPrice());
		
	}
	
	

}
