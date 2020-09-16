package outbackv2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JpaBoardDto;
import outbackv2.service.BoardService;



@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	

	
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	//목록
	@GetMapping("/board/list/{page}")
	public ModelAndView list (@PathVariable int page) {
		ModelAndView mv=service.list(page);
		mv.setViewName("/board/list");
		return mv;
	}
	
	//글쓰기 페이지 (단순 페이지 이동)
	@GetMapping("/board/write")
	public String write() {
		return "/board/write";
	}
	
	//글쓰기 페이지 (데이터 처리)
	@PostMapping("/board/write")
	public String write(JpaBoardDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.write(dto);
		return "redirect:/board/list/1";
	}
	
	//상세 페이지
	@GetMapping("/board/{no}")
	public String detail(@PathVariable Long no, Model model) {
		JpaBoardDto result=service.detail(no);
		model.addAttribute("dto", result);
		return "/board/detail";
		
	}
	
	//삭제
	@GetMapping("/board/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return "redirect:/board/list/1";
	}
	
	//수정
	@PostMapping("/board/edit")
	public String edit(JpaBoardDto dto) {
		service.edit(dto);
		return "redirect:/board/"+dto.getNo();
	}

}
