package com.HiBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class HiBookApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(HiBookApplication.class, args);
	}

}
