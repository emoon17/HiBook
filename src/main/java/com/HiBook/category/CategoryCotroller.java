package com.HiBook.category;

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
public class CategoryCotroller {
	
	@Autowired
	private Passing passing;

	
	// 국내도서 view
	@GetMapping("/hikorean_view")
	public String hikorean_Book_view(Model model) throws ParseException {
		
		//소설 / 시
		List<Map<String,Object>> koreanNovelBookList = passing.koreanNovelPoemBookList();
		model.addAttribute("koreanNovelBookList", koreanNovelBookList);
		// 경제경영 / 자기계발
		List<Map<String,Object>> koreanEconomyBookList = passing.koreanEconomyBookList();
		model.addAttribute("koreanEconomyBookList", koreanEconomyBookList);
		// 어린이 / 만화
		List<Map<String,Object>> koreanEssayBookList = passing.koreanEssayBookList();
		model.addAttribute("koreanEssayBookList", koreanEssayBookList);
		
		model.addAttribute("veiwName", "category/korean");

		return "template/layout";
	}
	
	// 국외도서 view
	@GetMapping("/hiforeign_view")
	public String hiforeign_Book_view(Model model)throws ParseException {
		
		// 소설 시
		List<Map<String, Object>> foreignBookNovelPoemList = passing.foreignBookNovelPoemList();
		model.addAttribute("foreignBookNovelPoemList", foreignBookNovelPoemList);
		
		// 어린이
		List<Map<String, Object>> foreignChildrenBookList = passing.foreignChildrenBookList();
		model.addAttribute("foreignChildrenBookList", foreignChildrenBookList);
		
		
		//일본도서
		List<Map<String, Object>> foreignJapaneseBookList = passing.foreignJapaneseBookList();
		model.addAttribute("foreignJapaneseBookList", foreignJapaneseBookList);
		
		model.addAttribute("veiwName", "category/foreign");

		return "template/layout";
				
	}
	
	// e-book view
	@GetMapping("/hiebook_view")
	public String hiebook_view(Model model)throws ParseException {
		
		//소설 / 시 / 희곡
		List<Map<String, Object>> eBookNovelPoemBookList = passing.eBookNovelPoemBookList();
		model.addAttribute("eBookNovelPoemBookList", eBookNovelPoemBookList);
		
		//경제경영 / 자기계발
		List<Map<String, Object>> eBookHumanitiesBookList = passing.eBookHumanitiesBookList();
		model.addAttribute("eBookHumanitiesBookList", eBookHumanitiesBookList);
		
		//만화
		List<Map<String, Object>> eBookToonList = passing.eBookToonList();
		model.addAttribute("eBookToonList", eBookToonList);
		
		model.addAttribute("veiwName", "category/ebook");

		return "template/layout";
	}
}
