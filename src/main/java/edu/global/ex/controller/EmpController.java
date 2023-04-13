//Object Controller
package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.repository.Criteria;
import edu.global.ex.service.BoardService;
import edu.global.ex.service.EmpService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.EmpVO;
import edu.global.ex.vo.GradeVO;
import edu.global.ex.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //log
@Controller
@RequestMapping("/emp/*")
@RequiredArgsConstructor
public class EmpController {

	
	@Autowired
	private EmpService empService; //injection
	
//	@Autowired
//	private GradeVO gradeVO;
	
	@GetMapping("/list")
	public String view_list(Model model) {
		log.info("view_list()..");
		System.out.println("view_list()..");
		
//		System.out.println("gradeVO");
		
		model.addAttribute("emps", empService.getList());
		
		return "/emp/emp_list";
	}
	
	
	@GetMapping("/content_view")
	public String content_view(EmpVO empVO, Model model) {
		log.info("content_view()..");
		
		int empno = empVO.getEmpno();
		
		empVO = empService.get(empno);

		model.addAttribute("content_view", empVO);
		return "/emp/content_view";
	}
	
	
	// http://localhost:8282/list2
	// list2?pageNum=5&amount=10">1</a>
	@GetMapping("/list2")
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);

		model.addAttribute("empDepts", empService.getList(cri));

		int total = empService.getTotal();
		log.info("total" + total);

		model.addAttribute("pageMaker", new PageVO(cri, total));

		return "/emp/emp_list2";
	}
	
	@GetMapping("/dept1")
	public String dept1() {
		log.info("dept1()..");
		
		System.out.println(empService.getEmpDeptVOList());
		
		return "/emp/emp_list2";
	}
	
	
}
