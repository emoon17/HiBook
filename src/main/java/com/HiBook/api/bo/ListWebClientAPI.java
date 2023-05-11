package com.HiBook.api.bo;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import reactor.core.publisher.Mono;

@Service
public class ListWebClientAPI {
	
	
	private final String baseURL = "https://aladin.co.kr/ttb/api/ItemList.aspx?";
	private final String key = "ttbwjddmsgo452053001";
	private String lastUrl = "&QueryType=BlogBest&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101";
	
	public String BlogBestkList() {
		
		// 모든 설정을 customization할 수 있도록 build
		/*
		 * WebClient webclient = WebClient.builder() .baseUrl(baseURL)
		 * .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		 * .build();
		 */
		
		// uribuild 설정을 도와주는 DefaultUriBUilderFactory 호출
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseURL);
		
		// 인코딩 모드 설정
		factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY); // VALUES_ONLY인코딩 : 템플릿을 인코딩하지 않고 URI 변수를 템플릿에 적용하기 전에 엄격히 인코딩한다.
		
		WebClient webClient = WebClient.builder()
				.uriBuilderFactory(factory)
	 			.baseUrl(baseURL)
				.build();
		
		// baseURL 뒤에 붙일 파라미터들 넣기
		//https://aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbwjddmsgo452053001
		//&QueryType=BlogBest
		//&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101
		String response = webClient.get()
	            .uri(uriBuilder -> uriBuilder
	                .queryParam("key", key)
	                .queryParam("lastUrl", lastUrl)
	                .build())
	            .retrieve()   //응답값을 받게 해주는 메소드
	            .bodyToMono(String.class) // response body를 String 타입으로 받게 해줌
	            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
		
		return response;
	}

}
