package edu.global.ex.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	//페이징 처리를 위해선 페이지 번호와 한페이지당 몇개의 데이터를 보여줄 것인지 결정되어야만 함
	private int pageNum; //page number
	private int amount; //한페이지당 몇개의 페이지를 보여줄 것인
	
	public Criteria() {
		this(1,10); //default 1page, set maximum 10
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
				
	}
}
