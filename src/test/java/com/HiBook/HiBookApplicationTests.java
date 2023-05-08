package com.HiBook;

import org.junit.jupiter.api.Test;
import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HiBookApplicationTests {
	
	Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	@Test //테스트로 수행할 거면 어노테이션 두기.
	void contextLoads() {
		logger.info("###########더하기 테스트 ######");
	}
	
	

}
