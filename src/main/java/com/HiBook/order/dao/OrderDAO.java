package com.HiBook.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.HiBook.order.model.Order;

@Repository
public interface OrderDAO {

	public void insertOrderByProductIdCountPriceUserId(
			@Param("orderproductId") Integer orderproductId, 
			@Param("orderNumber") Integer orderNumber, 
			@Param("count") Integer count, 
			@Param("price") Integer price, 
			@Param("userId") Integer userId);
	
	public List<Order> selectOrderListByUserId(Integer userId);
}

