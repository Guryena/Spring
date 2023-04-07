package com.example.ex.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex.vo.GradeVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;

@RequestMapping("/grade")
@Controller
public class GradeController {
	
	@GetMapping("/")
	public String grade_form() {
		return "grade_form";
	}
//	@GetMapping("/total")
//	public String grade_form(HttpServletRequest request, Model model) {
//		int kor = Integer.valueOf(request.getParameter("kor"));
//		int eng= Integer.valueOf(request.getParameter("eng"));
//		int math = Integer.valueOf(request.getParameter("math"));
//		int total = kor + eng + math;
//		double avg = total / 3.0;
//		
//		model.addAttribute("total", total);
//		model.addAttribute("avg", avg);
//		
//		return "grade";
//	}
//	@PostMapping("/")
//	public String grade_form() {
//		return "grade_form";
//	}
	@PostMapping("/total2")
//	public String grade_form(HttpServletRequest request, Model model) {
								
	//GradeVO is command object
	//If it want to use, must input '@NoArgsConstructor' in class
		public String grade_form(GradeVO gradeVO, Model model) {
//		int kor = Integer.valueOf(request.getParameter("kor"));
//		int eng= Integer.valueOf(request.getParameter("eng"));
//		int math = Integer.valueOf(request.getParameter("math"));
//		int total = kor + eng + math;
//		double avg = total / 3.0;
		
//		GradeVO grade = new GradeVO(kor, eng, math);
		
		model.addAttribute("grade", gradeVO);
		
		return "grade";
	}
}
