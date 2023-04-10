package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.dao.BoardDAO;
import edu.global.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //log
@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoardServieceImpl implements BoardService{

	@Autowired //injection    private BoardDAO = new BoardDAO();
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList()");
		
		return dao.boardSelect();
	}

	
}
