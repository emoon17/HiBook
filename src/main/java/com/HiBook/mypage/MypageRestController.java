package com.HiBook.mypage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/hibook/mypage")
@RestController
public class MypageRestController {

	
	@PutMapping("/information_update")
	public Map<String, Object> informationUpdate(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("loginId") String loginId,
			@RequestParam("address") String address,
			@RequestParam("files") List<MultipartFile> files,
			HttpSession session){
		
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		//db update
		
		// 결과 나누기
		result.put("code", 1);
		// 응답
		
		return result;
	}
}
