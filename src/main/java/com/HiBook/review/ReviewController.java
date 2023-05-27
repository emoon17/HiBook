package com.HiBook.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hiBook")
@Controller
public class ReviewController {

	@GetMapping("/mypage/my_review_view")
	public String review_view(Model model) {
		
		model.addAttribute("veiwName", "mypage/myReview");

		return "template/layout";
	}
}
