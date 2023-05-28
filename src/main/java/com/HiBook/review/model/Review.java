package com.HiBook.review.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Review {
	
	private int id; 
	private String isbn13;
	private int userId;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String sdate) {
		this.createdAt = sdate;
	}
	
	
}
