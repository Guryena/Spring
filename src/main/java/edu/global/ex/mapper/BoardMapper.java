package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.repository.Criteria;
import edu.global.ex.vo.BoardVO;

@Mapper // mybatis
public interface BoardMapper {
	public List<BoardVO> getList();

	public BoardVO read(int bid); // 파라미터는 url로 넘어오는 bid값을 의미

	public int update(BoardVO board); // edit method

	public int delete(BoardVO board); // delete method

	public int insert(BoardVO board); // insert method

	// reply
	public void updateShape(BoardVO board); // reply position

	public void insertReply(BoardVO board); // reply commit

	// paging
	public List<BoardVO> getListWithPaging(Criteria cri);

	public int getTotalCount();

}
