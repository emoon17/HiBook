package com.HiBook.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HiBook.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	//loginId 중복확인
	public boolean existLoginId(String loginId) {
		return userDAO.existLoginId(loginId);
	}

}
