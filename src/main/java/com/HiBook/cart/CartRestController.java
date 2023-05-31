package com.HiBook.cart;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.product.model.Product;
import com.HiBook.purchase.bo.PurchaseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@RestController
public class CartRestController {
	
	@Autowired
	private PurchaseBO purchaseBO;

	@PostMapping("/cart_create")
	public Map<String, Object> cartCreate(
			@RequestParam("count") Integer count,
			@ModelAttribute Product product,
			HttpSession session){
		
		// userId
		Integer userId = (Integer)session.getAttribute("userId");
		// cart insert
		// purchaseBO 가져오기
		purchaseBO.addcartAndProductByCountIsbn13TitlePriceUserId(count, product, userId);
		// 결과 나누기
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		
		//응답
		return result;
	}
}
