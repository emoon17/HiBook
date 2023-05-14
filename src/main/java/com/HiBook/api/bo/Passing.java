package com.HiBook.api.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class Passing {
	
	@Autowired
	private ListRestAPI listRestApi;
	
	@Autowired
	private WebClientAPI WebClientApi;
	//베스트 셀러 리스트 파싱
	public List<Map<String,Object>> bestBookParshing() throws JsonProcessingException, org.json.simple.parser.ParseException{
		
		String json = listRestApi.bestSellerBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
		
		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;
		
		List<Map<String, Object>> bestBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);
			
			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String pubDate = (String) book.get("pubDate");
			String priceSales = String.valueOf(book.get("priceSales"));
			String cover = (String) book.get("cover");
			String description = (String) book.get("description");
			String bestRank = String.valueOf(book.get("bestRank"));
			String reviewRank = String.valueOf(book.get("customerReviewRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			
			map.put("isbn13", isbn13);
			map.put("title", title);
			map.put("author", author);
			map.put("pubdate", pubDate);
			map.put("pricesales", priceSales);
			map.put("cover", cover);
			map.put("description", description);
			map.put("bestRank", bestRank);
			map.put("customerReviewRank", reviewRank);
			
			bestBookList.add(map);
			
		}
		return bestBookList;
	}
	
	// 베스트 블로그 리스트 파싱
	public List<Map<String,Object>> bestBlogParshing() throws ParseException {
		
		String json = WebClientApi.BlogBestkList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
		
		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;
		
		List<Map<String, Object>> bestBlogBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);
			
			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String pubDate = (String) book.get("pubDate");
			String priceSales = String.valueOf(book.get("priceSales"));
			String cover = (String) book.get("cover");
			String description = (String) book.get("description");
			String bestRank = String.valueOf(book.get("bestRank"));
			String reviewRank = String.valueOf(book.get("customerReviewRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			
			map.put("isbn13", isbn13);
			map.put("title", title);
			map.put("author", author);
			map.put("pubdate", pubDate);
			map.put("cover", cover);
			map.put("description", description);
			map.put("bestRank", bestRank);
			map.put("customerReviewRank", reviewRank);
			
			bestBlogBookList.add(map);
			
		}
		return bestBlogBookList;
		
	}
	
	// 상품 조회 파싱
	public List<Map<String,Object>> inquiryBookPassing(String isbn13) throws ParseException {
		
		String json = WebClientApi.inquiryBookAPI(isbn13);

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
		
		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;
		
		List<Map<String, Object>> inquiryBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);
			
			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String pubDate = (String) book.get("pubDate");
			String priceSales = String.valueOf(book.get("priceSales"));
			String cover = (String) book.get("cover");
			String description = (String) book.get("description");
			String bestRank = String.valueOf(book.get("bestRank"));
			String reviewRank = String.valueOf(book.get("customerReviewRank"));
			
			map.put("title", title);
			map.put("author", author);
			map.put("pubdate", pubDate);
			map.put("cover", cover);
			map.put("description", description);
			
			map.put("priceSales", priceSales);
			map.put("bestRank", bestRank);
			map.put("customerReviewRank", reviewRank);
			
			inquiryBookList.add(map);
			
		}
		return inquiryBookList;
		
	}

}
