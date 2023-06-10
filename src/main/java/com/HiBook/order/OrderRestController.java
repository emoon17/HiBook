package com.HiBook.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.order.bo.OrderBO;
import com.HiBook.product.model.Product;
import com.HiBook.purchase.bo.PurchaseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@RestController
public class OrderRestController {

	@Autowired
	private PurchaseBO purchaseBO;
	

	// cart -> order insert
	@PostMapping("/order/order_create")
	public Map<String, Object> orderCreate(@RequestParam(value = "productIdArr[]") List<Integer> productId,
			HttpSession session) {

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

	// detail -> orderProduct 바로 주문하기
	@PostMapping("/order/direct_create")
	public Map<String, Object> directCreat(@ModelAttribute Product product, @RequestParam("count") Integer count,
			@RequestParam("title") String title, @RequestParam("price") Integer price, HttpSession session) {
		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}

		// product, orderproduct insert
		purchaseBO.addProductAndOrderProductByProductCountUserId(product, count, title, price, userId);
		// 응답
		result.put("code", 1);
		return result;
	}

	// orderproduct -> order(결제하기)
	@PostMapping("/order/payment")
	public Map<String, Object> orderPayment(@RequestParam("orderproductIdArr[]") List<Integer> orderproductIdArr,
			@RequestParam("orderNumber") Integer orderNumber, @RequestParam("count") Integer count,
			@RequestParam("price") Integer price, @RequestParam("postcode") String postcode,
			@RequestParam("address") String address, @RequestParam("detailAddress") String detailAddress,
			@RequestParam("phoneNumber") String phoneNumber, HttpSession session) {

		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}

		// order insert
		purchaseBO.addOrder(orderproductIdArr, orderNumber, count, price, postcode, address, detailAddress, phoneNumber,
				userId);
		// 응답
		result.put("code", 1);

		return result;

	}
	
	// 반품하기
	@PutMapping("/order/order_update")
	public Map<String, Object> orderUpdate(@RequestParam("orderNumberArr[]") List<Integer> orderNumberArr,
			HttpSession session) {
		// userId
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		
		//update
		purchaseBO.updateOrderAndOrderprdocutByOrderNumber(orderNumberArr, userId);
		//응답
		result.put("code", 1);
		return result;
	}

}
