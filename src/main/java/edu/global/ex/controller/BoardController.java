package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j //log
@Controller
@RequestMapping("/jboard/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String view_list(Model model) {
		log.info("view_list()..");
		System.out.println("view_list()..");
		
		model.addAttribute("boards", boardService.getList());
		
		return "/board/list";
	}
}
