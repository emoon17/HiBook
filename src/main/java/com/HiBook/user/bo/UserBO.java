package com.HiBook.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.user.dao.UserDAO;
import com.HiBook.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	//loginId 중복확인
	public boolean existLoginId(String loginId) {
		return userDAO.existLoginId(loginId);
	}
	
	//회원가입
	public void addUser(String name, String loginId, String password, String phoneNumber, String address, String kakaoCheck, String profileImage) {
		userDAO.insertUser(name, loginId, password, phoneNumber, address, kakaoCheck, profileImage);
	}
	
	// 로그인하기
	
	public User getUserByLoginIdPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdPassword(loginId, password);
	}
	
	public User getUserById(int userId) {
		return userDAO.selectUserById(userId);
		
	}
	

}
