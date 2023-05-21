package com.HiBook.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.HiBook.user.model.User;

@Repository
public interface UserDAO {

	public boolean existLoginId(String loginId);
	
	public void insertUser(
			@Param("name") String name,
			@Param("loginId") String loginId, 
			@Param("password") String password,
			@Param("phoneNumber") String phoneNumber, 
			@Param("address") String address,
			@Param("kakaoCheck") String kakaoCheck,
			@Param("profileImage") String profileImage
			);
	
	public User selectUserByLoginIdPassword(
			@Param("loginId") String loginId, 
			@Param("password") String password);
	
	public User selectUserById(int userId);
}
