package com.HiBook.orderproduct.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.HiBook.orderproduct.model.Orderproduct;

@Repository
public interface OrderproductDAO {

	
	public void insertOrderProductByProductIdCountPrice(
			@Param("productId") Integer productId,
			@Param("count") Integer count,
			@Param("price") Integer price,
			@Param("userId") Integer userId);
	
	public List<Orderproduct> selectOrderProductListById(Integer productId);

	public List<Orderproduct> selectOrderProductListByUserId(Integer userId);
}
