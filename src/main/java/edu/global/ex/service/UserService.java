package edu.global.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service  //Tell Spring that it is an MyBatis interface
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void addUser(UserVO user) {
		log.info("addUser()..");
		
		userMapper.insertUser(user); //User를 Insert에 넣은 후
		userMapper.insertAuthorities(user); //권한 설정
		
	}

	public void addUser2(UserVO user) {
		log.info("addUser2()..");
		
		userMapper.insertUser(user); //User를 Insert에 넣은 후
		
		user = null; //test를 위한 null 초기화
		
		userMapper.insertAuthorities(user); //권한 설정
		
	}

	// 3.아래 처럼 @Transactional 을 붙임
	//롤백에 되어 아무런 데이터가 들어 가지 않음
	@Transactional
	public void addUser3(UserVO user) {
		log.info("addUser3()..");
		
		userMapper.insertUser(user); //User를 Insert에 넣은 후
		
		user = null; //test를 위한 null 초기화
		
		userMapper.insertAuthorities(user); //권한 설정
		
	}
	
	  // 4.checked Exception을 강제로 시켜 봄 //롤백 되지 않음
	   @Transactional
	   public void addUser4(UserVO user) throws Exception {
	      log.info("addUser4()..");

	      userMapper.insertUser(user); // User를 insert를 넣은후
	      userMapper.insertAuthorities(user);

	      // throw Checked Exception
	      throw new Exception("Exception (Checked Exception)");
	   }
	   
	   // 5.unchecked Exception을 강제로 시켜 봄 //롤백 된다
	   @Transactional
	   public void addUser5(UserVO user) throws Exception {
		   log.info("addUser5()..");
		   
		   userMapper.insertUser(user); // User를 insert를 넣은후
		   userMapper.insertAuthorities(user);
		   
		   // throw unChecked Exception
		   throw new Exception("Exception (Unchecked Exception)");
	   }

	   
	   // 6.rollback option //do rollback
	   @Transactional(rollbackFor = Exception.class)
	   public void addUser6(UserVO user) throws Exception {
		   log.info("addUser6()..");
		   
		   userMapper.insertUser(user); // User를 insert를 넣은후
		   userMapper.insertAuthorities(user);
		   
		   // throw unChecked Exception
		   throw new Exception("Exception (Unchecked Exception)");
	   }
}
