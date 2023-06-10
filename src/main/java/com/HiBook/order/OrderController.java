package com.HiBook.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HiBook.order.model.OrderView;
import com.HiBook.purchase.bo.PurchaseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@Controller
public class OrderController {
	@Autowired
	private PurchaseBO purchaseBO;

	// 주문 조회, 반품 신청 view
	@GetMapping("/order_inquiry_view")
	public String orderInquiryView(Model model, HttpSession session) {

		// userId
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}

		List<OrderView> orderViewList = purchaseBO.getOrderViewListByUserId(userId);
		model.addAttribute("orderViewList", orderViewList);
		model.addAttribute("veiwName", "mypage/orderInquiry");

		return "template/layout";
	}
}
