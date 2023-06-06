package com.HiBook.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.HiBook.product.model.Product;

@Repository
public interface ProductDAO {

	public void insertProductByIsbn13(
			Product product);
	
	public List<Product> selectProductList(Integer productId);
	
	public void deleteProudctById(Integer productId);
	
	public Product selectPriceByProductId(Integer productId);
	
	public List<Product> selectProductAllList();
	
}
