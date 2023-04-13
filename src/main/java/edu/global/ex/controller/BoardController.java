//Object Controller
package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.repository.Criteria;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // log
@Controller
@RequestMapping("/jboard/*")
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	private BoardService boardService; // injection

//	@Autowired
//	private GradeVO gradeVO;

	@GetMapping("/list")
	public String view_list(Model model) {
		log.info("view_list()..");
		System.out.println("view_list()..");

//		System.out.println("gradeVO");

		model.addAttribute("boards", boardService.getList());

		return "/board/list";
	}

	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view()..");

		int bid = boardVO.getBid();

		boardVO = boardService.get(bid);

		model.addAttribute("content_view", boardVO);
		return "/board/content_view";
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify()..");

		int rn = boardService.modify(boardVO);

		log.info("modify()..result number : " + rn);

		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete()..");

		int rn = boardService.remove(boardVO);

		log.info("delete()..result number : " + rn);

		return "redirect:list";
	}

	@GetMapping("/write_view")
	public String write_view() {

		return "/board/write_view";
	}

	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");

		int rn = boardService.register(boardVO);

		return "redirect:list";
	}

	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()..");

		model.addAttribute("reply_view", boardService.get(boardVO.getBid()));
		return "/board/reply_view";
	}

	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");

		boardService.registerReply(boardVO);

		return "redirect:list";
	}

	// http://localhost:8282/list2
	// list2?pageNum=5&amount=10">1</a>
	@GetMapping("/list2")
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);

		model.addAttribute("boards", boardService.getList(cri));

		int total = boardService.getTotal();
		log.info("total" + total);

		model.addAttribute("pageMaker", new PageVO(cri, total));

		return "/board/list2";
	}

}
