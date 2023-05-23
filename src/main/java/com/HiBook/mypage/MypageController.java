package com.HiBook.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hiBook/mypage")
@Controller
public class MypageController {

	
	@GetMapping("/user_information_view")
	public String userInformationView(Model model) {
		
		
		model.addAttribute("veiwName", "mypage/userInformation");

		return "template/layout";
	}
}
