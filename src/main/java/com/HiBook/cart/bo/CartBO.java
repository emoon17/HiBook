package com.HiBook.cart.bo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.cart.dao.CartDAO;
import com.HiBook.cart.model.Cart;
import com.HiBook.cart.model.CartView;
import com.HiBook.product.bo.ProductBO;
import com.HiBook.product.model.Product;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

@Service
public class CartBO {
	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserBO userBO;
	@Autowired
	private ProductBO productBO;


	public void addCartByProductIdUserIdCountPrice(Integer productId, Integer userId, Integer count, Integer price){
		
		price = count * price;
		
		cartDAO.insertCartByProductIdUserIdCountPrice(productId, userId, count, price);
		
	}
	
	public void deleteCartBYProductIdUserId(Integer productId, Integer userId) {
		cartDAO.deleteCartBYProductIdUserId(productId, userId);
	}
	
	public Cart getCartByProductId(Integer productId) {
		
		return cartDAO.selectCartByProductId(productId);
	}

	public void updateCartByCountProductIdUserId(Integer productId, Integer count, Integer price, Integer userId){
	
		cartDAO.updateCartByCountProductIdUserId(productId, count, price, userId);
	}
	
	
	public List<Cart> getCartList(Integer userId){
		return cartDAO.selectCartList(userId);
	}
	
	public List<Cart> getCartListByProductIdUserId(Integer productId, Integer userId) {
		return cartDAO.selectCartListByProductIdUserId(productId, userId);
	}
	
	public List<CartView> getCartViewList(Integer userId){
		
		List<CartView> cartViewList = new ArrayList<>();
		
		List<Cart> cartList = getCartList(userId);
		for (Cart cart : cartList) {
			CartView cartView = new CartView();
			DecimalFormat df = new DecimalFormat("###,###");
			cartView.setCart(cart);
			User user = userBO.getUserById(cart.getUserId());
			cartView.setUser(user);
			List<Product> productList = productBO.getProductList(cart.getProductId());
			for (Product product : productList) {
				cartView.setProduct(product);
			}
			cartViewList.add(cartView);
			
		}
		return cartViewList;
	}
}
