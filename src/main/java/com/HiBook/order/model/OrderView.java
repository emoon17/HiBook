package com.HiBook.order.model;

import com.HiBook.orderproduct.model.Orderproduct;
import com.HiBook.product.model.Product;

public class OrderView {
	
	private Order order;
	private Product product;
	private Orderproduct orderproduct;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orderproduct getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(Orderproduct orderproduct) {
		this.orderproduct = orderproduct;
	}
	
	
}
