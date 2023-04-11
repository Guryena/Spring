package edu.global.ex.vo;


import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component //스프링으로 하여금 loc 컨테이너에 객체생성해서 넣어라
@Getter
@Setter
@ToString
@AllArgsConstructor
public class GradeVO {
	int kor;
	int eng;
	int math;
	
	public GradeVO() {
		this.kor = 85;
		this.eng = 80;
		this.math = 95;
	}
}
