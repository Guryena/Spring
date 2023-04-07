package com.example.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "test"; //test.jsp
	}
	@GetMapping("/test2")
	public String test2() {
		return "test/test2"; //test.jsp
	}
	@GetMapping("test/test3")
	public String test3() {
		return "test/test2"; //test.jsp
	}
	@RequestMapping("test/test4") //old ver.
	public String test4() {
		return "test/test4"; //test.jsp
	}
}
