package com.HiBook.review;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HiBook.review.bo.ReviewBO;
import com.HiBook.review.model.ReviewView;

import javax.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;

	// 마이페이지 마이리뷰 페이지
	@GetMapping("/mypage/my_review_view")
	public String review_view(Model model) {

		model.addAttribute("veiwName", "mypage/myReview");

		return "template/layout";
	}

	//마이리뷰 날짜 조회
	@GetMapping("/mypage/my_review_search_view")
	public String myReviewSearchView(
			@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			HttpSession session, Model model) throws ParseException {
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		List<ReviewView> myReviewViewList = reviewBO.getDateCommentList(startDate, endDate, userId);
		model.addAttribute("myReviewViewList", myReviewViewList);
		
		

 		return "mypage/myReviewSearch";
	}
}
