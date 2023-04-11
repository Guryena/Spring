//Object Command 
package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.dao.BoardDAO;
import edu.global.ex.vo.BoardMapper;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //log
@Service
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor //Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션이다.
public class BoardServieceImpl implements BoardService{

//	@Autowired //injection    private BoardDAO = new BoardDAO();
//	private BoardDAO dao;
	
//	@Autowired //Constructor injection 
//	private GradeVO gradeVO;

	@Autowired
	private final BoardMapper mapper;
	
//	@Autowired
//	public BoardServieceImpl(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
	
	//Setter injection
//	@Autowired
//	public void setGradeVO(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
	
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList()");
		
//		return dao.boardSelect();
		return mapper.getlist();
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		
		log.info("get(int bno)..");
		
//		return dao.contentView(bno);
		return null;
	}
	
	

	
}
