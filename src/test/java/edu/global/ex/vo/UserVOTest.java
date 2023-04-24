package edu.global.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserVOTest {

	@Test
	void test() {
		UserVO vo = new UserVO();
		log.info("create object" + vo);
		assertNotNull(vo);
		
		vo.setPassword("1234");
		vo.setUsername("TIM");
		
		System.out.println(vo);
		
		assertNotNull(vo);
		assertEquals(vo.getUsername(), "DAVID");
	}

}
