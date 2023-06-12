package com.HiBook.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HiBook.api.bo.Passing;
@RequestMapping("/hiBook")	
@RestController
public class MainRestController {
	@Autowired
	private Passing passing;
	@GetMapping("/main_search")
	public Map<String, Object> mainSearch(@RequestParam("keyword") String keyword) throws ParseException{
		
		List<Map<Object, Object>> keywordBookList = passing.keywordBookPassing(keyword);
		Map<String, Object> result = new HashMap<>();
		if (keywordBookList == null) {
			result.put("errorMessage", "조회 된 항목이 없습니다.");
		}
		result.put("code", 1);
		
		return result;
	}
		
		
	
	

}
