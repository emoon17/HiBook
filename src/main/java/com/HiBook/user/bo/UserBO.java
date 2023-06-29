package com.HiBook.user.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.HiBook.common.FileManagerService;
import com.HiBook.kakao.bo.KakaoUserInfoBO;
import com.HiBook.user.dao.UserDAO;
import com.HiBook.user.model.User;

@Service
public class UserBO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FileManagerService fileManagerService;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private KakaoUserInfoBO kakaoUserInfoBO;

	// loginId 중복확인
	public boolean existLoginId(String loginId) {
		return userDAO.existLoginId(loginId);
	}

	// 회원가입
	public void addUser(String name, String loginId, String password, String phoneNumber, String postcode,
			String address, String detailAddress, String kakaoCheck, String profileImage) {

		userDAO.insertUser(name, loginId, password, phoneNumber, postcode, address, detailAddress, kakaoCheck,
				profileImage);
	}

	// 로그인하기

	public User getUserByLoginIdPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdPassword(loginId, password);
	}

	public User getUserById(int userId) {
		return userDAO.selectUserById(userId);

	}

	public List<User> getUserListBYId(Integer userId) {
		return userDAO.selectUserListBYId(userId);
	}

	// update
	public void informationUpdate(String name, String phoneNumber, String loginId, String postcode, String address,
			String detailAddress, MultipartFile file, Integer userId) {

		List<User> userList = getUserListBYId(userId);

		for (User user : userList) {
			if (user == null) {
				logger.warn("=========[update post] 수정할 사용자가 존재하지 않습니다. userId:{}", userId);
				return;
			}

		}

		// 파일 업로드 => 내 컴퓨터 서버에만 올린다. 경로로 보여지기.
		String imagePath = fileManagerService.saveFile(loginId, file);

		userDAO.informationUpdate(name, phoneNumber, loginId, postcode, address, detailAddress, imagePath, userId);
	}

	// order시 업데이트
	public void userAddressUpdate(String phoneNumber, String postcode, String address, String detailAddress,
			Integer userId) {
		userDAO.userAddressUpdate(phoneNumber, postcode, address, detailAddress, userId);
	}

	// 카카오 유저 insert
	public void addKakaoUser(User user) {

		userDAO.insertKakaoUser(user);
	}

	// 이메일 셀렉
	public User getUserByEmail(String email) {
		return userDAO.selectUserByEmail(email);
	}

	// kakaoId 셀렉
	public User getUserByKakaoId(String kakaoId) {
		return userDAO.selectUserByKakaoId(kakaoId);
	}

	//카카오 로그인
	@Transactional
	public User saveUser(String name, String profileImage, String email, String kakaoId) {
		// KakaoUserInfo userInfo = kakaoUserInfoBO.ResponseGetUserInfo(accessToken);

		// accessTokenUserInfo.properties.getNickname(),accessTokenUserInfo.properties.getProfile_image()
		// ,accessTokenUserInfo.kakao_account.email
		User user = getUserByKakaoId(kakaoId);
		// KakaoUser kakaoUser = new KakaoUser();

		if (user == null) {
			String[] loginIdArr = email.split("@");
			String loginId = loginIdArr[0];

			User users = new User();
			users.setName(name);
			users.setLoginId(loginId);
			users.setProfileImage(profileImage);
			users.setKakaoCheck("여");
			users.setEmail(email);
			users.setKakaoId(kakaoId);
			addKakaoUser(users);
			user = getUserById(users.getId());

		}

		// 이메일 있으면
		return user;

	}

}
