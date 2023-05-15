package com.HiBook.user.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public boolean existLoginId(String loginId);
}
