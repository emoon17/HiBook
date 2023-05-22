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

	// 베스트 셀러 리스트 파싱
	public List<Map<String, Object>> bestBookParshing()
			throws JsonProcessingException, org.json.simple.parser.ParseException {

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
	public List<Map<String, Object>> bestBlogParshing() throws ParseException {

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

	// 국내도서 소설/시 리스트 파싱
	public List<Map<String, Object>> koreanNovelPoemBookList() throws ParseException {

		String json = WebClientApi.koreanNovelPoemBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> koreanNovelBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("국내도서>소설")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				koreanNovelBookList.add(map);
				if (koreanNovelBookList.size() > 5) {
					koreanNovelBookList.remove(koreanNovelBookList.size() - 1);
				}
			}

		}
		return koreanNovelBookList;

	}

	// 국내도서 경제경영 / 자기계발 리스트 파싱
	public List<Map<String, Object>> koreanEconomyBookList() throws ParseException {

		String json = WebClientApi.koreanNovelPoemBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> koreanEconomyBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("국내도서>경제경영") || categoryName.contains("국내도서>자기계발")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				koreanEconomyBookList.add(map);
				if (koreanEconomyBookList.size() > 5) {
					koreanEconomyBookList.remove(koreanEconomyBookList.size() - 1);
				}
			}

		}
		return koreanEconomyBookList;

	}

	// 국내도서 어린이 / 만화 리스트 파싱
	public List<Map<String, Object>> koreanEssayBookList() throws ParseException {

		String json = WebClientApi.koreanNovelPoemBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> koreanEssayBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("국내도서>어린이") || categoryName.contains("국내도서>만화")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				koreanEssayBookList.add(map);
				if (koreanEssayBookList.size() > 5) {
					koreanEssayBookList.remove(koreanEssayBookList.size() - 1);
				}
			}

		}
		return koreanEssayBookList;

	}

	// 국외도서 소설 / 시
	public List<Map<String, Object>> foreignBookNovelPoemList() throws ParseException {

		String json = WebClientApi.foreignBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> foreignBookNovelPoemList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("소설") || categoryName.contains("문학") || categoryName.contains("인문")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				foreignBookNovelPoemList.add(map);
				if (foreignBookNovelPoemList.size() > 5) {
					foreignBookNovelPoemList.remove(foreignBookNovelPoemList.size() - 1);
				}
			}

		}
		return foreignBookNovelPoemList;

	}

	// 국외도서 일본도서
	public List<Map<String, Object>> foreignJapaneseBookList() throws ParseException {

		String json = WebClientApi.foreignBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> foreignJapaneseBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("일본")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				foreignJapaneseBookList.add(map);
				if (foreignJapaneseBookList.size() > 5) {
					foreignJapaneseBookList.remove(foreignJapaneseBookList.size() - 1);
				}
			}

		}
		return foreignJapaneseBookList;

	}

	// 국외도서 일본도서
	public List<Map<String, Object>> foreignChildrenBookList() throws ParseException {

		String json = WebClientApi.foreignBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> foreignChildrenBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("어린이")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				foreignChildrenBookList.add(map);
				if (foreignChildrenBookList.size() > 5) {
					foreignChildrenBookList.remove(foreignChildrenBookList.size() - 1);
				}
			}

		}
		return foreignChildrenBookList;

	}

	// e-book 소설 /시 /희곡
	public List<Map<String, Object>> eBookNovelPoemBookList() throws ParseException {

		String json = WebClientApi.eBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> eBookNovelPoemBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("소설")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				eBookNovelPoemBookList.add(map);
				if (eBookNovelPoemBookList.size() > 5) {
					eBookNovelPoemBookList.remove(eBookNovelPoemBookList.size() - 1);
				}
			}

		}
		return eBookNovelPoemBookList;

	}

	// e-book 교양/인문학
	public List<Map<String, Object>> eBookHumanitiesBookList() throws ParseException {

		String json = WebClientApi.eBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> eBookHumanitiesBookList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("교양") || categoryName.contains("인문학")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				eBookHumanitiesBookList.add(map);
				if (eBookHumanitiesBookList.size() > 5) {
					eBookHumanitiesBookList.remove(eBookHumanitiesBookList.size() - 1);
				}
			}

		}
		return eBookHumanitiesBookList;

	}

	// e-book 교양/인문학
	public List<Map<String, Object>> eBookToonList() throws ParseException {

		String json = WebClientApi.eBookList();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);

		JSONArray item = (JSONArray) jsonObject.get("item");
		JSONObject book;

		List<Map<String, Object>> eBookToonList = new ArrayList<>();
		for (int i = 0; i < item.size(); i++) {
			book = (JSONObject) item.get(i);

			Map<String, Object> map = new HashMap<String, Object>();
			String title = (String) book.get("title");
			String author = (String) book.get("author");
			String cover = (String) book.get("cover");
			String bestRank = String.valueOf(book.get("bestRank"));
			String isbn13 = String.valueOf(book.get("isbn13"));
			String categoryName = (String) book.get("categoryName");

			if (categoryName.contains("만화")) {
				map.put("isbn13", isbn13);
				map.put("title", title);
				map.put("author", author);
				map.put("cover", cover);
				map.put("bestRank", bestRank);

				eBookToonList.add(map);
				if (eBookToonList.size() > 5) {
					eBookToonList.remove(eBookToonList.size() - 1);
				}
			}

		}
		return eBookToonList;

	}

	// 상품 조회 파싱
	public List<Map<String, Object>> inquiryBookPassing(String isbn13) throws ParseException {

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
			map.put("isbn13", isbn13);

			inquiryBookList.add(map);

		}
		return inquiryBookList;

	}

}
