package com.HiBook.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/hiBook")
@Controller
public class MainController {
	
	//메인화면
	@GetMapping("/main/main_veiw")
	public String mainView () {
		return "main/main";
	}

}
