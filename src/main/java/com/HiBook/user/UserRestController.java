package com.HiBook.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.HiBook.common.EncrypUtils;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

import javax.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@RestController
public class UserRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserBO userBO;

	// 아이디 중복확인
	@PostMapping("/user/is_duplicated_id")
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
	@PostMapping("/user/sign_up")
	public Map<String, Object> signUp(@RequestParam("name") String name, @RequestParam("loginId") String loginId,
			@RequestParam("password") String password, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("postcode") String postcode, @RequestParam("address") String address, @RequestParam(value="kakaoCheck", required=false, defaultValue="부") String kakaoCheck,
			@RequestParam("detailAddress") String detailAddress, @RequestParam(value="profileImage", required=false) String profileImage) {

		// 비밀번호 해싱
		String HashedPassword = EncrypUtils.md5(password);

		// insert
		userBO.addUser(name, loginId, HashedPassword, phoneNumber, postcode, address, detailAddress, kakaoCheck, profileImage);
		// 결과 넣기
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		// 응답 내리기
		return result;

	}
	
	// 로그인하기
	@PostMapping("/user/sign_in")
	public Map<String, Object> signIn(String loginId, String password, HttpSession session){
		
		// 1. 비밀번호 해싱
		String HashedPassword = EncrypUtils.md5(password);
	
		// 2. select
		User user = userBO.getUserByLoginIdPassword(loginId, HashedPassword);
		System.out.println("####프로필 이미지" + user.getProfileImage());
		// 3. 결과 코드 나누고 성공시 세션에 담아두기
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			result.put("code", 1);
			session.setAttribute("userId", user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("loginId", user.getLoginId());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("phoneNumber", user.getPhoneNumber());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("postcode", user.getPostcode());
			session.setAttribute("detailAddress", user.getDetailAddress());
			session.setAttribute("kakaoCheck", user.getKakaoCheck());
			session.setAttribute("profileImage", user.getProfileImage());
		} else {
			result.put("erroMessage", "아이디, 비밀번호를 확인해주세요.");
		}
		// 4. 응답
		return result;
	
	}
	
	// update
	
	@PutMapping("/mypage/information_update")
	public Map<String, Object> informationUpdate(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="phoneNumber", required=false) String phoneNumber,
			@RequestParam(value="loginId", required=false) String loginId,
			@RequestParam(value="address", required=false) String address,
			@RequestParam(value="postcode", required=false) String postcode,
			@RequestParam(value="detailAddress", required=false) String detailAddress,
			@RequestParam(value="file", required=false) MultipartFile file,
			HttpSession session){
		
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		//db update
		userBO.informationUpdate(name, phoneNumber, loginId,  postcode, address, detailAddress, file, userId);
		session.removeAttribute("name");
		session.removeAttribute("phoneNumber");
		session.removeAttribute("loginId");
		session.removeAttribute("address");
		
		User user = userBO.getUserById(userId);
//		session.setAttribute("name", user.getName());
//		session.setAttribute("phoneNumber", user.getPhoneNumber());
//		session.setAttribute("loginId", user.getLoginId());
//		session.setAttribute("postcode", user.getPostcode());
//		session.setAttribute("address", user.getAddress());
//		session.setAttribute("detailAddress", user.getDetailAddress());
		// 결과 나누기
		result.put("code", 1);
		// 응답
		
		return result;
	}

}
