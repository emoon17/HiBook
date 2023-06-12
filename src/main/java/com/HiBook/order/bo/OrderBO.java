package com.HiBook.order.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.order.dao.OrderDAO;
import com.HiBook.order.model.Order;
import com.HiBook.review.model.Review;

@Service
public class OrderBO {

	@Autowired
	private OrderDAO orderDAO;

	public void addOrderByProductIdCountPriceUserId(Integer orderproductId, Integer orderNumber, Integer count,
			Integer price, Integer userId) {
		orderDAO.insertOrderByProductIdCountPriceUserId(orderproductId, orderNumber, count, price, userId);
	}

	public List<Order> getOrderListByUserId(Integer userId) {
		return orderDAO.selectOrderListByUserId(userId);
	}

	public List<Order> getOrderListByOrderNumber(Integer orderNumber) {
		return orderDAO.selectOrderListByOrderNumber(orderNumber);
	}

	public List<Order> getOrderListByStartDateEndDateUserId(Date startDate, Date endDate, Integer userId) {
		return orderDAO.selectOrderListByStartDateEndDateUserId(startDate, endDate, userId);
	}
	
	public List<Order> getOrderListUpdateByStartDateEndDateUserId(Date startDate, Date endDate, Integer userId){
		return orderDAO.selectOrderListUpdateByStartDateEndDateUserId(startDate, endDate, userId);
	}

	public void updateOrderByOrderNumber(Integer orderNumber, Integer userId) {

		orderDAO.updateOrderByOrderNumber(orderNumber, userId);

	}

}
