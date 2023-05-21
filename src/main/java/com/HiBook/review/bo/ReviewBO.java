package com.HiBook.review.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addReviewByIsbn13UserIdComment(String isbn13, String content, Integer userId) {
		reviewDAO.insertReviewByIsbn13UserIdComment(isbn13, content, userId);
	}
	
	
	public List<Review> getReviewListByIsbn13 (String isbn13) {
		return reviewDAO.selectReviewListByIsbn13(isbn13);
		
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
	
	public void deleteReviewByIsbn13ContentUserId(String isbn13, String content, Integer userId) {
		reviewDAO.deleteReviewByIsbn13ContentUserId(isbn13, content, userId);
	}
}
