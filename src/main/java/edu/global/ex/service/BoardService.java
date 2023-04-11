package edu.global.ex.service;

import java.util.List;

import edu.global.ex.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	public BoardVO get(int bno);
}
