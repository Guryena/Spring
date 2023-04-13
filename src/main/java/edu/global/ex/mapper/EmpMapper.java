package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.repository.Criteria;
import edu.global.ex.vo.EmpVO;

@Mapper
public interface EmpMapper {
	public List<EmpVO> getList();
	public EmpVO read(int empno);
	public List<EmpVO> getListWithPaging(Criteria cri);
	public int getTotalCount();
}
