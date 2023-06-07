package com.HiBook.order.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO {

	public void insertOrderByProductIdUserIdOrderproductIdCountPriceState(
			@Param("productId") Integer productId,
			@Param("userId") Integer userId, 
			@Param("count") Integer count, 
			@Param("price") Integer price);
}
