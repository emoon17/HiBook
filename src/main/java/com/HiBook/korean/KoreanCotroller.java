package com.HiBook.korean;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HiBook.api.bo.Passing;
@RequestMapping("/hiBook")
@Controller
public class KoreanCotroller {
	
	@Autowired
	private Passing passing;

	
	// 국내도서 view
	@GetMapping("/hikorean_view")
	public String hikorean_Book_view(Model model) throws ParseException {
		
		List<Map<String,Object>> koreanNovelBookList = passing.koreanNovelPoemBookList();
		model.addAttribute("koreanNovelBookList", koreanNovelBookList);
		
		model.addAttribute("veiwName", "korean/korean");

		return "template/layout";
	}
}
