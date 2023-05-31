package com.HiBook.cart.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.cart.dao.CartDAO;

@Service
public class CartBO {
	
	@Autowired
	private CartDAO cartDAO;

	public void addCartByProductIdUserIdCountPrice(Integer productId, Integer userId, Integer count, Integer price){
		
		price = count * price;
		
		cartDAO.insertCartByProductIdUserIdCountPrice(productId, userId, count, price);
		
		
		
	}
}
