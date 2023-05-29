package com.HiBook.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/hiBook")
@Controller
public class CartController {
	
	@GetMapping("/mypage/cart_view")
	public String review_view(Model model) {

		model.addAttribute("veiwName", "mypage/cart");

		return "template/layout";
	}
	


}
