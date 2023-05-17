package com.HiBook.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.common.EncrypUtils;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook/user")
@RestController
public class UserRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserBO userBO;

	// 아이디 중복확인
	@PostMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(@RequestParam("loginId") String loginId) {

		// select
		boolean isDuplicatedId = userBO.existLoginId(loginId);

		// map 코드 나누기
		Map<String, Object> result = new HashMap<String, Object>();
		if (isDuplicatedId) { // 중복
			result.put("code", 1);
			result.put("result", true);
		} else {
			logger.warn("[아이디 중복확인] post is null. loginId:{}", loginId);
			result.put("result", false);
		}

		// response
		return result;
	}

	// 회원가입하기
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(@RequestParam("name") String name, @RequestParam("loginId") String loginId,
			@RequestParam("password") String password, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address, @RequestParam(value="kakaoCheck", required=false, defaultValue="부") String kakaoCheck,
			@RequestParam(value="profileImage", required=false) String profileImage) {

		// 비밀번호 해싱
		String HashedPassword = EncrypUtils.md5(password);

		// insert
		userBO.addUser(name, loginId, HashedPassword, phoneNumber, address, kakaoCheck, profileImage);
		// 결과 넣기
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		// 응답 내리기
		return result;

	}
	
	// 로그인하기
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(String loginId, String password, HttpSession session){
		
		// 1. 비밀번호 해싱
		String HashedPassword = EncrypUtils.md5(password);
	
		// 2. select
		User user = userBO.getUserByLoginIdPassword(loginId, HashedPassword);
		// 3. 결과 코드 나누고 성공시 세션에 담아두기
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("code", 1);
			session.setAttribute("name", user.getName());
			session.setAttribute("loginId", user.getLoginId());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("phoneNumber", user.getPhoneNumber());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("kakaoCheck", user.getKakaoCheck());
			session.setAttribute("profileImage", user.getProfileImage());
		} else {
			result.put("erroMessage", "아이디, 비밀번호를 확인해주세요.");
		}
		// 4. 응답
		return result;
	
	}

}
