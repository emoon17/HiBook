package com.HiBook.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.HiBook.cart.model.Cart;

@Repository
public interface CartDAO {

	public void insertCartByProductIdUserIdCountPrice(
			@Param("productId") Integer productId, 
			@Param("userId") Integer userId, 
			@Param("count") Integer count, 
			@Param("price") Integer price);
	
	public List<Cart> selectCartList(Integer userId);
	
	public void deleteCartBYProductIdUserId(
			@Param("productId") Integer productId, 
			@Param("userId") Integer userId);
	
	public void updateCartByCountProductIdUserId(
			@Param("productId") Integer productId,
			@Param("count") Integer count,
			@Param("price") Integer price,
			@Param("userId") Integer userId);
	
	
	public Cart selectCartByProductId(Integer productId);
}
