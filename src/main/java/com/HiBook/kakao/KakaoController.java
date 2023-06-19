package com.HiBook.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HiBook.kakao.bo.KakaoLoginBO;
import com.HiBook.kakao.bo.KakaoUserInfoBO;
import com.HiBook.kakao.model.KakaoToken;
import com.HiBook.kakao.model.KakaoUserInfo;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class KakaoController {

	@Autowired
	private KakaoLoginBO kakaoLoginBO;
	
	@Autowired
	private KakaoUserInfoBO kakaoUserInfoBO;
	
	@Autowired
	private UserBO userBO;

	// 1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
	@GetMapping("/kakaoLogin")
	public String kakaoLogin(@RequestParam("code") String code, HttpSession session){

		// 1번
		System.out.println("code:" + code);
		// return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음

		// 2번
		KakaoToken accessToken = kakaoLoginBO.getToken(code);
		System.out.println("###access_Token#### : " + accessToken.getAccess_token());
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행

//		// 3번
		KakaoUserInfo accessTokenUserInfo = kakaoUserInfoBO.ResponseGetUserInfo(accessToken.getAccess_token());
		System.out.println("###access_TokenUserInfo#### : " + accessTokenUserInfo.getKakao_account().getEmail());
		System.out.println("###UserInfo#### : " + accessTokenUserInfo);
		
		// user insert
		User user = userBO.saveUser(accessToken.getAccess_token());
		session.setAttribute("userId", user.getId());
		session.setAttribute("name", user.getName());
		session.setAttribute("loginId", user.getLoginId());
		session.setAttribute("kakaoCheck", user.getKakaoCheck());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("profileImage", user.getProfileImage());

		return "redirect:/hiBook/main/main_veiw";
	}
}