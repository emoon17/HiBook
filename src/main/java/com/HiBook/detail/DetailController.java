package com.HiBook.detail;

import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HiBook.api.bo.Passing;

@RequestMapping("/hiBook")
@Controller
public class DetailController {

	@Autowired
	private Passing passing;
	
	
	@GetMapping("/hi_detail_view")
	public String detailView(@RequestParam("isbn13") String isbn13,
			Model model) throws ParseException {
		
		
		List<Map<String, Object>> inquiryBookList = passing.inquiryBookPassing(isbn13);
		model.addAttribute("inquiryBookList", inquiryBookList);
		
		model.addAttribute("veiwName", "detail/detail");

		return "template/layout";
	}

}
