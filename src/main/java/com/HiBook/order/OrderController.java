package com.HiBook.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hiBook")
@Controller
public class OrderController {

	// 주문 조회, 반품 신청 view
	@GetMapping("/order_inquiry_view")
	public String orderInquiryView(Model model) {
		
		model.addAttribute("veiwName", "mypage/orderInquiry");

		return "template/layout";
	}
}
