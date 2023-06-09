package com.HiBook.orderproduct.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.orderproduct.dao.OrderproductDAO;
import com.HiBook.orderproduct.model.Orderproduct;
import com.HiBook.product.bo.ProductBO;
import com.HiBook.product.model.Product;

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
	
	public List<Orderproduct> getOrderproductListByUserId(Integer userId){
		return orderproductDAO.selectOrderProductListByUserId(userId);
	}
	
	public void updateOrderproductById(Integer id) {
		orderproductDAO.updateOrderproductById(id);
	}
	
}
