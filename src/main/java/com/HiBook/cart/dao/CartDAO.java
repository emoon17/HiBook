package com.HiBook.cart.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO {

	public void insertCartByProductIdUserIdCountPrice(
			@Param("productId") Integer productId, 
			@Param("userId") Integer userId, 
			@Param("count") Integer count, 
			@Param("price") Integer price);
}
