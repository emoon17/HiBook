package com.HiBook.orderproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HiBook.orderproduct.bo.OrderproductBO;
import com.HiBook.orderproduct.model.OrderProductView;
import com.HiBook.purchase.bo.PurchaseBO;

import javax.servlet.http.HttpSession;
@RequestMapping("/hiBook")
@Controller
public class OrderproductController {

	@Autowired
	private OrderproductBO orderproductBO;
	@Autowired
	private PurchaseBO purchaseBO;
	
	// 주문화면
	@GetMapping("/order_product_view")
	public String review_view(Model model, HttpSession session) {

		// userId
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}
		List<OrderProductView> orderproductViewList = purchaseBO.getOrderproductList(userId);
		model.addAttribute("orderproductViewList", orderproductViewList);
		
		model.addAttribute("veiwName", "mypage/order");

		return "template/layout";
	}
}
