package edu.global.ex.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
		
	
	@Test
	void addUsertest() {
		UserVO vo = new UserVO();
		log.info("create object" +vo);
		
		vo.setUsername("SMITH");
		vo.setPassword("1234");
		
		System.out.println(vo);
		
		assertNotNull(vo);
		assertEquals(vo.getUsername(), "SMITH");
		
		userService.addUser(vo);
	}

}
