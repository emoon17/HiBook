package com.HiBook.kakao.bo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import reactor.core.publisher.Flux;

@Component
public class KakaoUserInfoBO {

	private static final String USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";

	public String KakaoUserInfoResponseGetUserInfo(String token) {
		String uri = USER_INFO_URI;

		// uribuild 설정을 도와주는 DefaultUriBUilderFactory 호출
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(USER_INFO_URI);

		// 인코딩 모드 설정
		factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY); // VALUES_ONLY인코딩 : 템플릿을 인코딩하지 않고
																					// URI 변수를 템플릿에 적용하기 전에 엄격히 인코딩한다.

		WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(USER_INFO_URI).build();

		Flux<String> response = webClient.get().uri(uri).header("Authorization", "Bearer " + token).retrieve()
				.bodyToFlux(String.class);

		return response.blockFirst();
	}

}
