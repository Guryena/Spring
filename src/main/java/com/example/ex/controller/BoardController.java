package com.example.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//1.how to use URL and page mapping
//2.send data from view(JSP)
@RequestMapping("/board")
@Controller
public class BoardController {
	@GetMapping("/content")
	public String content() {
		return "board/content";
	}
	
	@GetMapping("/")
	public String main() {
		return "board/main";
	}
	
	@GetMapping("/content_view")
	public String content_view(Model model) {
		model.addAttribute("id", 30);
		model.addAttribute("pw", "1234");
		return "board/content";
	}
		
	@GetMapping("/reply")
	public ModelAndView model_view() {
		
		ModelAndView mv =new ModelAndView();
		mv.addObject("id", 50);
		mv.addObject("pw", "1234");
		mv.setViewName("board/reply");
		
		return mv;
	}
	
}
