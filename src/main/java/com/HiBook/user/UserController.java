package com.HiBook.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/hiBook")
@Controller
public class UserController {
	
	// 회원가입 화면
	@GetMapping("/user/sign_up_view")
	public String signUpView (Model model){
		
		model.addAttribute("veiwName", "user/signUp");
		
		return "template/layout";
	}

	
	// 로그인 화면
	@GetMapping("/user/sign_in_view")
	public String signInView(Model model) {

		model.addAttribute("veiwName", "user/signIn");

		return "template/layout";
	}
	
	// 로그아웃 	
	@GetMapping("/user/sign_out")
	public String signOut(HttpSession session) {
		
		//로그인 시 세션에 담아뒀던 정보 지우기 
		session.removeAttribute("userId");
		session.removeAttribute("name");
		session.removeAttribute("loginId");
		session.removeAttribute("password");
		session.removeAttribute("phoneNumber");
		session.removeAttribute("postcode");
		session.removeAttribute("detailAddress");
		session.removeAttribute("address");
		session.removeAttribute("kakaoCheck");
		session.removeAttribute("profileImage");
		
		return "redirect:/hiBook/main/main_veiw";
	}
	
	// 개인정보 수정
	@GetMapping("/mypage/user_information_view")
	public String userInformationView(Model model, HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}
		model.addAttribute("veiwName", "mypage/userInformation");

		return "template/layout";
	}
	
}
