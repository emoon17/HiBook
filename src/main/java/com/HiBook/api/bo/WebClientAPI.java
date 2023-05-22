package com.HiBook.api.bo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class WebClientAPI {
	
	
	private final String baseURL = "https://aladin.co.kr";
	private final String key = "ttbwjddmsgo452053001";
	
	// 베스트 블로그 리스트 API 가져오기
	public String BlogBestkList() {
		String QueryType = "BlogBest";
		String MaxResults = "10";
		String start = "1";
		String SearchTarget = "book";
		String output = "JS";
		String Version = "20131101";
		
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
		//https://aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=zl
		//&QueryType=BlogBest
		//&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101
		String response = webClient.get()
	            .uri(uriBuilder -> uriBuilder.path("/ttb/api/ItemList.aspx")
	                .queryParam("ttbkey", key)
	                .queryParam("QueryType", QueryType)
	                .queryParam("MaxResults", MaxResults)
	                .queryParam("start", start)
	                .queryParam("SearchTarget", SearchTarget)
	                .queryParam("output", output)
	                .queryParam("Version", Version)
	                .build())
	            .retrieve()   //응답값을 받게 해주는 메소드
	            .bodyToMono(String.class)// response body를 String 타입으로 받게 해줌
	            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
		
		return response;
	}
	
	// 상품 조회 api 가져오기
		public String inquiryBookAPI(String isbn13) {
			String itemIdType = "ISBN";
			String ItemId = isbn13;
			String output = "JS";
			String Version = "20131101";
			String OptResult = "ebookList,usedList,reviewList";
		
			
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
		//	https://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?
			//ttbkey=dd&itemIdType=
			//ISBN&ItemId=9791190299770&output=JS&Version=20131101
			//&OptResult=ebookList,usedList,reviewList
			String response = webClient.get()
		            .uri(uriBuilder -> uriBuilder.path("/ttb/api/ItemLookUp.aspx")
		                .queryParam("ttbkey", key)
		                .queryParam("itemIdType", itemIdType)
		                .queryParam("ItemId", ItemId)
		                .queryParam("output", output)
		                .queryParam("Version", Version)
		                .queryParam("OptResult", OptResult)
		                .build())
		            .retrieve()   //응답값을 받게 해주는 메소드
		            .bodyToMono(String.class)// response body를 String 타입으로 받게 해줌
		            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
			
			return response;
		}
		
		
//		https://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=
//			&QueryType=ItemNewAll
//			&SearchTarget=Book
//			&output=JS
//			&Version=20131101
		// 국내도서 API 가져오기
		public String koreanNovelPoemBookList() {
			String QueryType = "Bestseller";
			String MaxResults = "200";
			String start = "1";
			String SearchTarget = "Book";
			String output = "JS";
			String Version = "20131101";
			
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
			//https://aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=zl
			//&QueryType=BlogBest
			//&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101
			String response = webClient.get()
		            .uri(uriBuilder -> uriBuilder.path("/ttb/api/ItemList.aspx")
		                .queryParam("ttbkey", key)
		                .queryParam("QueryType", QueryType)
		                .queryParam("MaxResults", MaxResults)
		                .queryParam("start", start)
		                .queryParam("SearchTarget", SearchTarget)
		                .queryParam("output", output)
		                .queryParam("Version", Version)
		                .build())
		            .retrieve()   //응답값을 받게 해주는 메소드
		            .bodyToMono(String.class)// response body를 String 타입으로 받게 해줌
		            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
			
			return response;
		}
		
		
//		https://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=
//			&QueryType=BestSeller
//			&MaxResults=10
//			&start=1
//			&SearchTarget=Foreign
//			&output=JS
//			&Version=20131101
	// 국외도서 API 가져오기
	public String foreignBookList() {
		String QueryType = "Bestseller";
		String MaxResults = "200";
		String start = "1";
		String SearchTarget = "Foreign";
		String output = "JS";
		String Version = "20131101";
		
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
		//https://aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=zl
		//&QueryType=BlogBest
		//&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101
		String response = webClient.get()
	            .uri(uriBuilder -> uriBuilder.path("/ttb/api/ItemList.aspx")
	                .queryParam("ttbkey", key)
	                .queryParam("QueryType", QueryType)
	                .queryParam("MaxResults", MaxResults)
	                .queryParam("start", start)
	                .queryParam("SearchTarget", SearchTarget)
	                .queryParam("output", output)
	                .queryParam("Version", Version)
	                .build())
	            .retrieve()   //응답값을 받게 해주는 메소드
	            .bodyToMono(String.class)// response body를 String 타입으로 받게 해줌
	            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
		
		return response;
	}
	
	// e-book API 가져오기
		public String eBookList() {
			String QueryType = "Bestseller";
			String MaxResults = "200";
			String start = "1";
			String SearchTarget = "eBook";
			String output = "JS";
			String Version = "20131101";
			
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
			//https://aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=zl
			//&QueryType=BlogBest
			//&MaxResults=10&start=1&SearchTarget=book&output=JS&Version=20131101
			String response = webClient.get()
		            .uri(uriBuilder -> uriBuilder.path("/ttb/api/ItemList.aspx")
		                .queryParam("ttbkey", key)
		                .queryParam("QueryType", QueryType)
		                .queryParam("MaxResults", MaxResults)
		                .queryParam("start", start)
		                .queryParam("SearchTarget", SearchTarget)
		                .queryParam("output", output)
		                .queryParam("Version", Version)
		                .build())
		            .retrieve()   //응답값을 받게 해주는 메소드
		            .bodyToMono(String.class)// response body를 String 타입으로 받게 해줌
		            .block();  //webclient는 기본적으로 비동기 방식인데 block메서드를 이용해 동기 방식 -없으면 String으로 못 바꿈.
			
			return response;
		}
	
}


