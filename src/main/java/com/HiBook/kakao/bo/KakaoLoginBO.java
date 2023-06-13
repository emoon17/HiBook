package com.HiBook.kakao.bo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Component
public class KakaoLoginBO {

	    private static String TOKEN_URI = "https://kauth.kakao.com/oauth/token";
	    private static String REDIRECT_URI = "https://localhost/kakaoLogin";
	    private static String GRANT_TYPE = "authorization_code";
	    private static String CLIENT_ID = "da00e9c9a82581ec40c118b0897e344d";

	    public String getToken(String code) {
	    	
	    	DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(TOKEN_URI);

			// 인코딩 모드 설정
			factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY); // VALUES_ONLY인코딩 : 템플릿을 인코딩하지 않고
																						// URI 변수를 템플릿에 적용하기 전에 엄격히 인코딩한다.

			WebClient webClient = WebClient.builder().uriBuilderFactory(factory).baseUrl(TOKEN_URI).build();
			
			//String uri = TOKEN_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&code=" + code;
			// baseURL 뒤에 붙일 파라미터들 넣기
			String uri = TOKEN_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&code=" + code;
			Flux<String> response = webClient.post()
					.uri(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.retrieve() // 응답값을 받게 해주는 메소드
					.bodyToFlux(String.class);// response body를 String 타입으로 받게 해줌

			return response.blockFirst();
		}
//	        String uri = TOKEN_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&code=" + code;
//	        System.out.println(uri);
//
//	        Flux<KakaoTokenResponse> response = webClient.post()
//	                .uri(uri)
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .retrieve()
//	                .bodyToFlux(KakaoTokenResponse.class);
//
//	        return response.blockFirst();
//	    }
}
