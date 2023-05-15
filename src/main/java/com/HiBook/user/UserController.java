package com.HiBook.user;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
@RequestMapping("/hiBook/user")
@Controller
public class UserController {
	
	// 회원가입 화면
	@GetMapping("/sign_up_view")
	public String signUpView (Model model){
		
		model.addAttribute("veiwName", "user/signUp");
		
		return "template/layout";
	}

	
	// 로그인 화면
	@GetMapping("/sign_in_view")
	public String signInView(Model model) {

		model.addAttribute("veiwName", "user/signIn");

		return "template/layout";
	}
}
