package com.HiBook.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/hiBook")
@Controller
public class OrderController {

	@GetMapping("/mypage/order_view")
	public String review_view(Model model) {

		model.addAttribute("veiwName", "mypage/order");

		return "template/layout";
	}
}
