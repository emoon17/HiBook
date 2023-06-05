package com.HiBook.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HiBook.cart.bo.CartBO;
import com.HiBook.cart.model.CartView;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@Controller
public class CartController {
	
	@Autowired
	private CartBO cartBO;

	@GetMapping("/mypage/cart_view")
	public String review_view(Model model, HttpSession session) {

		// userId
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}
		
		List<CartView> cartViewList = cartBO.getCartViewList(userId);
		model.addAttribute("cartViewList", cartViewList);

		model.addAttribute("veiwName", "mypage/cart");

		return "template/layout";
	}

}
