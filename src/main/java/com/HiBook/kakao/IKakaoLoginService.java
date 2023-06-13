package com.HiBook.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface IKakaoLoginService {
	
	/*
	 * String getAccessToken(String authorize_code) throws Throwable;
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public HashMap<String, Object> getUserInfo(String access_Token)
	 * throws Throwable{ // 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
	 * HashMap<String, Object> userInfo = new HashMap<String, Object>(); String
	 * reqURL = "https://kapi.kakao.com/v2/user/me";
	 * 
	 * try { URL url = new URL(reqURL); HttpURLConnection conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod("GET");
	 * 
	 * // 요청에 필요한 Header에 포함될 내용 conn.setRequestProperty("Authorization", "Bearer "
	 * + access_Token);
	 * 
	 * int responseCode = conn.getResponseCode();
	 * System.out.println("responseCode : " + responseCode);
	 * 
	 * BufferedReader br = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream()));
	 * 
	 * String line = ""; String result = "";
	 * 
	 * while ((line = br.readLine()) != null) { result += line; }
	 * System.out.println("response body : " + result);
	 * System.out.println("result type" + result.getClass().getName()); //
	 * java.lang.String
	 * 
	 * try { // jackson objectmapper 객체 생성 ObjectMapper objectMapper = new
	 * ObjectMapper(); // JSON String -> Map Map<String, Object> jsonMap =
	 * objectMapper.readValue(result, new TypeReference<Map<String, Object>>() { });
	 * 
	 * System.out.println(jsonMap.get("properties"));
	 * 
	 * Map<String, Object> properties = (Map<String, Object>)
	 * jsonMap.get("properties"); Map<String, Object> kakao_account = (Map<String,
	 * Object>) jsonMap.get("kakao_account");
	 * 
	 * // System.out.println(properties.get("nickname")); //
	 * System.out.println(kakao_account.get("email"));
	 * 
	 * String nickname = properties.get("nickname").toString(); String email =
	 * kakao_account.get("email").toString();
	 * 
	 * userInfo.put("nickname", nickname); userInfo.put("email", email);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } return userInfo; }
	 */
}
