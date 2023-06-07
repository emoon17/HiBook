package com.HiBook.orderproduct.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.orderproduct.dao.OrderproductDAO;
import com.HiBook.orderproduct.model.Orderproduct;

@Service
public class OrderproductBO {

	@Autowired
	private OrderproductDAO orderproductDAO;
	
	public void addOrderProductByProductIdCountPriceUserId(
			Integer productId, Integer count, Integer price, Integer userId) {
		
		orderproductDAO.insertOrderProductByProductIdCountPrice(productId, count, price, userId);
	}
	
	public List<Orderproduct> getOrderProductListById(Integer productId){
		return orderproductDAO.selectOrderProductListById(productId);
	}
}
