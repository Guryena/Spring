package edu.global.ex.service;

import java.util.List;

import edu.global.ex.repository.Criteria;
import edu.global.ex.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList(); // list method
	public BoardVO get(int bid); //view method
	public int modify(BoardVO boardVO); //edit method
	public int remove(BoardVO boardVO); //remove method
	public int register(BoardVO boardVO); //write method
	public void registerReply(BoardVO boardVO); //reply method
	//paging
	public List<BoardVO> getList(Criteria cri);
	public int getTotal();
}
