package com.HiBook.order.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.order.dao.OrderDAO;
import com.HiBook.orderproduct.bo.OrderproductBO;
import com.HiBook.orderproduct.model.Orderproduct;

@Service
public class OrderBO {

	@Autowired
	private OrderDAO orderDAO;
	
	
	public void addOrderByProductIdCountPriceUserId(Integer productId, Integer orderNumber, Integer count, Integer price, Integer userId) {
		orderDAO.insertOrderByProductIdCountPriceUserId(productId, orderNumber, count, price, userId);
	}
}
