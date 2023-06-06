package com.HiBook.cart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.cart.dao.CartDAO;
import com.HiBook.product.model.Product;
import com.HiBook.purchase.bo.PurchaseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@RestController
public class CartRestController {

	@Autowired
	private PurchaseBO purchaseBO;
	@Autowired
	private CartDAO cartDAO;
	// 장바구니에 넣기
	@PostMapping("/cart_create")
	public Map<String, Object> cartCreate(@RequestParam("count") Integer count, @ModelAttribute Product product,
			HttpSession session) {

		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		// cart insert
		// purchaseBO 가져오기
		purchaseBO.addcartAndProductByCountIsbn13TitlePriceUserId(count, product, userId);
		// 결과 나누기
		result.put("code", 1);

		// 응답
		return result;
	}

	//장바구니 삭제
	@DeleteMapping("/cart_delete")
	public Map<String, Object> cartDelete(@RequestParam("productId") Integer ProductId, HttpSession session) {

		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		
		// cart delete
		purchaseBO.deleteCartANDProductBYProductIdUserId(ProductId, userId);
		//결과 
		result.put("code", 1);
		//응답
		return result;
	}
	
	//장바구니 수량 변경
	@PutMapping("/cart_update")
	public Map<String,Object> cartUpdate(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count,
			@RequestParam("price") Integer price, HttpSession session){
		
		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		// cart update
		purchaseBO.updateCartByCount(productId, count, price, userId);
		result.put("code", 1);
		//응답
		return result;
	}
}
