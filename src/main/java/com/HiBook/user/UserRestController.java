package com.HiBook.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.user.bo.UserBO;
@RequestMapping("/hiBook/user")
@RestController
public class UserRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	// 아이디 중복확인
	@PostMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId){
		
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
		
		//response
		return result;
	}
	
}
