package com.HiBook.order.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO {

	public void insertOrderByProductIdCountPriceUserId(
			@Param("orderproductId") Integer orderproductId, 
			@Param("orderNumber") Integer orderNumber, 
			@Param("count") Integer count, 
			@Param("price") Integer price, 
			@Param("userId") Integer userId);
}

