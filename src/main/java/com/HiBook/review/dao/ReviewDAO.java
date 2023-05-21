package com.HiBook.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.HiBook.review.model.Review;

@Repository
public interface ReviewDAO {

	public void insertReviewByIsbn13UserIdComment(
			@Param("isbn13") String isbn13, 
			@Param("content") String content, 
			@Param("userId") Integer userId);
	
	public List<Review> selectReviewListByIsbn13 (String isbn13);
	
	public void deleteReviewByIsbn13ContentUserId(
			@Param("isbn13") String isbn13, 
			@Param("content") String content, 
			@Param("userId") Integer userId);
}
