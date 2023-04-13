//Object Command 
package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.repository.BoardDAO;
import edu.global.ex.repository.Criteria;
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

	
//	@Autowired
//	public BoardServieceImpl(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
	
	//Setter injection
//	@Autowired
//	public void setGradeVO(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
	
	@Autowired
	private final BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList()");
		
//		return dao.boardSelect();
		return mapper.getList();
	}

	@Override
	public BoardVO get(int bid) {
		// TODO Auto-generated method stub
		
		log.info("get(int bid)..");
		
//		return dao.contentView(bno);
		return mapper.read(bid);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify()..");
		
		return mapper.update(board);
	}

	@Override
	public int remove(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("delete()..");
		return mapper.delete(board);
	}

	@Override
	public int register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register()..");
		return mapper.insert(board);
	}

	@Override
	public void registerReply(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.updateShape(board);
		mapper.insertReply(board);
		
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("getList(Criteria cri)..");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		log.info("getTotal()..");
		return mapper.getTotalCount();
	}

	
	

	
}
