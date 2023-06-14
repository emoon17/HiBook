package com.HiBook.kakao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HiBook.kakao.bo.KakaoLoginBO;
import com.HiBook.kakao.bo.KakaoUserInfoBO;
import com.HiBook.kakao.model.KakaoToken;

@Controller
public class KakaoController {

	@Autowired
	private KakaoLoginBO kakaoLoginBO;
	
	@Autowired
	private KakaoUserInfoBO kakaoUserInfoBO;

	// 1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
	@GetMapping("/kakaoLogin")
	public ModelAndView kakaoLogin(@RequestParam("code") String code)throws Throwable {

		// 1번
		System.out.println("code:" + code);
		// return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음

		// 2번
		KakaoToken accessToken = kakaoLoginBO.getToken(code);
		System.out.println("###access_Token#### : " + accessToken);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행

//		// 3번
//		String access_TokenUserInfo = kakaoUserInfoBO.KakaoUserInfoResponseGetUserInfo(access_Token);
//		System.out.println("###access_TokenUserInfo#### : " + access_TokenUserInfo);

		return null;
	}
}