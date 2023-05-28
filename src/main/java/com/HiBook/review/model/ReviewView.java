package com.HiBook.review.model;

import com.HiBook.user.model.User;

public class ReviewView {
	
	private Review review;
	private User user;
	private Object title;
	
	public Object getTitle() {
		return title;
	}
	public void setTitle(Object object) {
		this.title = object;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
