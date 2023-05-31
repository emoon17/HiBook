package com.HiBook.product.dao;

import org.springframework.stereotype.Repository;

import com.HiBook.product.model.Product;

@Repository
public interface ProductDAO {

	public void insertProductByIsbn13(
			Product product);
}
