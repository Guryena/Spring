package edu.global.ex.vo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper  //mybatis
public interface BoardMapper {
	public List<BoardVO> getlist();
}
