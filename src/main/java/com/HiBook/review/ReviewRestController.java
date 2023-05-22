package com.HiBook.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.review.bo.ReviewBO;

import jakarta.servlet.http.HttpSession;
@RequestMapping("/hibook/hi_detail")
@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	@PutMapping("/comment_create")
	public Map<String, Object> createReview(String isbn13, String content, HttpSession session) {
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		// userId 가져오기
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 500);
			result.put("errorMessage", "로그인 후 이용 가능합니다..");
			return result;
		}
		
		// insert시키기
		reviewBO.addReviewByIsbn13UserIdComment(isbn13, content, userId);
		// 결과 나누기
		result.put("code", 1);
		// 응답하기
		return result;
	}
	
	@DeleteMapping("/comment_delete")
	public Map<String, Object> deleteReview(String isbn13, String content, HttpSession session) {
		
		// userId가져오기
		Integer userId = (Integer)session.getAttribute("userId");
		// delete
		reviewBO.deleteReviewByIsbn13ContentUserId(isbn13, content, userId);
		
		// 결과 나누기
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("code", 1);
		
		// 응답하기
		return result;
	}

}
