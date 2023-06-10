package com.HiBook.order.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.order.dao.OrderDAO;
import com.HiBook.order.model.Order;

@Service
public class OrderBO {

	@Autowired
	private OrderDAO orderDAO;
	
	
	public void addOrderByProductIdCountPriceUserId(Integer orderproductId, Integer orderNumber, Integer count, Integer price, Integer userId) {
		orderDAO.insertOrderByProductIdCountPriceUserId(orderproductId, orderNumber, count, price, userId);
	}
	
	public List<Order> getOrderListByUserId(Integer userId){
		return orderDAO.selectOrderListByUserId(userId);
	}
	
}
