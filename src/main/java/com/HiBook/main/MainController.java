package com.HiBook.main;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HiBook.api.bo.Passing;
import com.fasterxml.jackson.core.JsonProcessingException;
@RequestMapping("/hiBook")
@Controller
public class MainController {
	
	@Autowired
	private Passing passing;
	
	
	
	//메인화면
	
	@GetMapping("/main/main_veiw")
	public String mainView (Model model) throws JsonProcessingException, ParseException {
		
		List<Map<String, Object>> bestBookList = passing.bestBookParshing();
		model.addAttribute("bestBookList", bestBookList);
		
		List<Map<String, Object>> bestBlogBookList = passing.bestBlogParshing();
		model.addAttribute("bestBlogBookList", bestBlogBookList);
		
		model.addAttribute("veiwName", "main/main");
		
		return "template/layout";
	}

}
