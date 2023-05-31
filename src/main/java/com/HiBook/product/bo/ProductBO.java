package com.HiBook.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.product.dao.ProductDAO;
import com.HiBook.product.model.Product;

@Service
public class ProductBO {

	@Autowired
	private ProductDAO productDAO;
	
	public void addProductByIsbn13(Product product) {
		productDAO.insertProductByIsbn13(product);
		
	}
	
	public List<Product> getProductList(Integer productId){
		return productDAO.selectProductList(productId);
	}
}
