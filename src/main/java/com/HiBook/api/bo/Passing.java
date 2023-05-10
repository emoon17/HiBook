package com.HiBook.api.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class Passing {
	
	@Autowired
	private ListRestAPI listRestApi;
	
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
			map.put("reviewRank", reviewRank);
			
			bestBookList.add(map);
			
		}
		return bestBookList;
	}

}