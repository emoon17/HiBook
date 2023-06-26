package com.HiBook.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.HiBook.user.model.User;

@Repository
public interface UserDAO {

	public boolean existLoginId(String loginId);
	
	public void insertUser(
			@Param("name") String name,
			@Param("loginId") String loginId, 
			@Param("password") String password,
			@Param("phoneNumber") String phoneNumber, 
			@Param("postcode") String postcode,
			@Param("address") String address,
			@Param("detailAddress") String detailAddress,
			@Param("kakaoCheck") String kakaoCheck,
			@Param("profileImage") String profileImage
			);
	
	public User selectUserByLoginIdPassword(
			@Param("loginId") String loginId, 
			@Param("password") String password);
	
	public User selectUserById(int userId);
	
	public List<User> selectUserListBYId(Integer userId);
	
	public void informationUpdate(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber,
			@Param("loginId") String loginId, 
			@Param("postcode") String postcode,
			@Param("address") String address, 
			@Param("detailAddress") String detailAddress,
			@Param("imagePath") String imagePath, 
			@Param("userId") Integer userId);
	
	public void userAddressUpdate(
			@Param("phoneNumber") String phoneNumber,
			@Param("postcode") String postcode,
			@Param("address") String address, 
			@Param("detailAddress") String detailAddress,
			@Param("userId") Integer userId);
	
	public void insertKakaoUser(User user);
	
	public User selectUserByEmail(String email);
}
