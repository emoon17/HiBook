package com.HiBook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class PermissionInterceptor implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 응답 내릴 때 아직 view( jsp)로 해석이 되지 않은 상태
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, 
				Object handler, ModelAndView mav) { 
			
			logger.info("[$$$$ posthandle]"); 
		}
		
		// view가 해석까지 다 되서 html이 된 상태 ?
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
				Object handler, Exception ex) {
			
			logger.info("[@@@@@ afterCompletion]");
		}

}
