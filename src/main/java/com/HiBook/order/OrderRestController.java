package com.HiBook.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.purchase.bo.PurchaseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@RestController
public class OrderRestController {

	@Autowired
	private PurchaseBO purchaseBO;
	
	// cart -> order insert
	@PostMapping("/order/order_create")
	public Map<String, Object> orderCreate(@RequestParam(value="productIdArr[]") List<Integer> productId, HttpSession session) {

		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		
		
//		 List <Integer> productId = new ArrayList<>();
//		 for (int i = 0; i <= productIdArr.length; i++ ) { 
//			 productId.add(i);
//		}
		 
		
		// order insert
		purchaseBO.addOrderProductAndOrderByProductIdUserId(productId, userId);
		result.put("code", 1);
		// 응답
		return result;
		
		
	}

}
