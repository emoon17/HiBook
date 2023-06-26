package com.HiBook.kakao.bo;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.HiBook.kakao.model.KakaoToken;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
@RequiredArgsConstructor
@Service
public class KakaoLoginBO {

	    private static String TOKEN_URI = "https://kauth.kakao.com/oauth/token";
	    private static String REDIRECT_URI = "http://localhost/kakaoLogin";
	    private static String GRANT_TYPE = "authorization_code";
	    private static String CLIENT_ID = "da00e9c9a82581ec40c118b0897e344d";
	    private static String CLIENT_Secret = "o3IXxbn8MeezmoICKavYT0aD15ZbOMCV";

	    
	    public KakaoToken getToken(String code) {
	    
	    	  //요청 param (body)
	        MultiValueMap<String , String> params = new LinkedMultiValueMap<>();
	        params.add("grant_type", GRANT_TYPE);
	        params.add("client_id",CLIENT_ID );
	        params.add("redirect_uri",REDIRECT_URI);
	        params.add("code", code);
	        params.add("client_secret", CLIENT_Secret);

			WebClient webClient = WebClient.create(TOKEN_URI);
			
			// baseURL 뒤에 붙일 파라미터들 넣기
			Flux<KakaoToken> response = webClient.post()
					.uri(TOKEN_URI)
					.body(BodyInserters.fromFormData(params))
					.header("Content-type","application/x-www-form-urlencoded;charset=utf-8" )
	                .retrieve()
	                .bodyToFlux(KakaoToken.class);
			
			return response.blockFirst();
	    }
	    

}
