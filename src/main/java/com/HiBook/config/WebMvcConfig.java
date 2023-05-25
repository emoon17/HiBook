package com.HiBook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.HiBook.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/images/**") // Web 이미지 주소 // http://localhost/images/aaaa_16205468768/sun.png
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 파일 위치 mac: file:// window:file:///
	//	.addResourceLocations("file://" + FileManagerService.FILE_UPLOAD_PATH); // 실제 파일 위치 mac: file:// window:file:///
	}
	
	
}
