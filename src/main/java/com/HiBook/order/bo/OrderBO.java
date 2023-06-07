package com.HiBook.order.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.order.dao.OrderDAO;

@Service
public class OrderBO {

	@Autowired
	private OrderDAO orderDAO;
	
	public void addOrderByProductIdUserIdOrderproductIdCountPriceState(Integer productId, Integer userId, 
			 Integer count, Integer price) {
		orderDAO.insertOrderByProductIdUserIdOrderproductIdCountPriceState(productId, userId, count, price);
	}

}
