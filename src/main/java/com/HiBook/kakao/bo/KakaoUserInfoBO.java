package com.HiBook.kakao.bo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.HiBook.kakao.model.KakaoUserInfo;

import reactor.core.publisher.Flux;

@Service
public class KakaoUserInfoBO {

	private static final String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";

	public KakaoUserInfo ResponseGetUserInfo(String token) {
		String uri = USER_INFO_URI;

		WebClient webClient = WebClient.create(USER_INFO_URI);

		Flux<KakaoUserInfo> response = webClient.get()
                .uri(uri)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(KakaoUserInfo.class);

        return response.blockFirst();
	}

}
