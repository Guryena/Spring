package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.vo.EmpDeptVo;


@Mapper
public interface DeptMapper {
	
	public List<EmpDeptVo> getEmpDeptOneVOList();
	
}
