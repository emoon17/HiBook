package com.HiBook.orderproduct.model;

import com.HiBook.product.model.Product;

public class OrderProductView {

	private Orderproduct orderproduct;
	private Product product;
	public Orderproduct getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(Orderproduct orderproduct) {
		this.orderproduct = orderproduct;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
