package com.HiBook.review.bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.api.bo.Passing;
import com.HiBook.review.dao.ReviewDAO;
import com.HiBook.review.model.Review;
import com.HiBook.review.model.ReviewView;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private UserBO userBO;
	@Autowired
	private Passing passing;
	
	public void addReviewByIsbn13UserIdComment(String isbn13, String content, Integer userId) {
		reviewDAO.insertReviewByIsbn13UserIdComment(isbn13, content, userId);
	}
	
	
	public List<Review> getReviewListByIsbn13 (String isbn13) {
		return reviewDAO.selectReviewListByIsbn13(isbn13);
		
	}
	
	public List<Review> getReviewListByStartDateEndDateUserId(Date startDate, Date endDate, Integer userId) {
		return reviewDAO.selectReviewListByStartDateEndDateUserId(startDate, endDate, userId);
	}
	
	public List<ReviewView> generateCommentList(String isbn13) {
		
		List<ReviewView> reviewViewList = new ArrayList<>();
		
		List<Review> reviewList = getReviewListByIsbn13(isbn13);
		
		for (Review review : reviewList) {
			ReviewView reviewView = new ReviewView();
			
			reviewView.setReview(review);
			
			User user = userBO.getUserById(review.getUserId());
			reviewView.setUser(user);
			
			
			reviewViewList.add(reviewView);
			
		}
		
		return reviewViewList;
	}
	//기간 조회 마이리뷰 리스트
	public List<ReviewView> getDateCommentList(Date startDate, Date endDate, Integer userId) throws ParseException {
		
		List<ReviewView> myReviewViewList = new ArrayList<>();
		
		List<Review> myReviewList = getReviewListByStartDateEndDateUserId(startDate, endDate, userId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String sdate = sdf.format(startDate); 
		for (Review review : myReviewList) {
			ReviewView reviewView = new ReviewView();
			
			reviewView.setReview(review);
			
			
			User user = userBO.getUserById(review.getUserId());
			reviewView.setUser(user);
			
		    List<Map<Object, Object>> inquiryBookPassingList = passing.inquiryBookPassing(review.getIsbn13());
		    for (int i = 0; i < inquiryBookPassingList.size(); i++) {
		    	reviewView.setTitle(inquiryBookPassingList.get(i).get("title"));
		    }
			myReviewViewList.add(reviewView);
			
		}
		
		return myReviewViewList;
	}
	
	
	
	public void deleteReviewByIsbn13ContentUserId(String isbn13, String content, Integer userId) {
		reviewDAO.deleteReviewByIsbn13ContentUserId(isbn13, content, userId);
	}
}
