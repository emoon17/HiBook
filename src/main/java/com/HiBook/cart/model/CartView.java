package com.HiBook.cart.model;

import com.HiBook.product.model.Product;
import com.HiBook.user.model.User;

public class CartView {
	
	private Cart cart;
	private Product product;
	private User user;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
