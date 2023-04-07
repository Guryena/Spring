package com.example.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor //create args
@Data
@AllArgsConstructor

public class GradeVO {
	private int kor;
	private int eng;
	private int math;
	
	
	public int getTotal() {
		return kor + eng + math;
	}
	
	public double getAvg(){
		return (kor + eng + math) / 3.0;
	}
	
	public char getGrade() {
		char grade= '가';
		
		if (getAvg()>=90) {
			grade ='수';
		}
		else if (getAvg()>=80) {
			grade ='우';
		}
		else if (getAvg()>=70) {
			grade ='미';
		}
		else if (getAvg()>=60) {
			grade ='양';
		}
		return grade;
	}
}
