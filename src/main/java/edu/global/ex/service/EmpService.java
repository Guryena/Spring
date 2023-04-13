package edu.global.ex.service;

import java.util.List;

import edu.global.ex.repository.Criteria;
import edu.global.ex.vo.EmpDeptVo;
import edu.global.ex.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> getList();
	public EmpVO get(int empno);
	
	//paging
	public List<EmpVO> getList(Criteria cri);
	public int getTotal();
	
	
	//1:N
	public List<EmpDeptVo> getEmpDeptVOList();
}
