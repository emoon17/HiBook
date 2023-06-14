package com.HiBook.kakao.bo;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.HiBook.kakao.model.KakaoToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class KakaoLoginBO {

	    private static String TOKEN_URI = "https://kauth.kakao.com/oauth/token";
	    private static String REDIRECT_URI = "https://localhost/kakaoLogin";
	    private static String GRANT_TYPE = "authorization_code";
	    private static String CLIENT_ID = "da00e9c9a82581ec40c118b0897e344d";
	    private static String CLIENT_Secret = "o3IXxbn8MeezmoICKavYT0aD15ZbOMCV";

	    public KakaoToken getToken(String code) {
	    

	    //	DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(TOKEN_URI);

			// 인코딩 모드 설정
			//factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY); // VALUES_ONLY인코딩 : 템플릿을 인코딩하지 않고
																						// URI 변수를 템플릿에 적용하기 전에 엄격히 인코딩한다.

	    	  //요청 param (body)
	        MultiValueMap<String , String> params = new LinkedMultiValueMap<>();
	        params.add("grant_type", GRANT_TYPE);
	        params.add("client_id",CLIENT_ID );
	        params.add("redirect_uri",REDIRECT_URI);
	        params.add("code", code);
	        params.add("client_secret", CLIENT_Secret);

			WebClient webClient = WebClient.create(TOKEN_URI);
			
			//String uri = TOKEN_URI + "?grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&code=" + code +"&client_secret=" + CLIENT_Secret;
			// baseURL 뒤에 붙일 파라미터들 넣기
			String response = webClient.post()
					.uri(TOKEN_URI)
					.body(BodyInserters.fromFormData(params))
					.header("Content-type","application/x-www-form-urlencoded;charset=utf-8" )
	                .retrieve()
	                .bodyToMono(String.class).block();
	                
//			 //json형태로 변환
	        ObjectMapper objectMapper = new ObjectMapper();
	        KakaoToken kakaoToken = null;

	        try {
	            kakaoToken = objectMapper.readValue(response, KakaoToken.class);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return kakaoToken;
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
