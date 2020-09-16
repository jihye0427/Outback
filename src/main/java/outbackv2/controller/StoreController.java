package outbackv2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.BoardDto;
import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyReqDto;
import outbackv2.service.StoreService;



@Controller
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	
	
	
	@GetMapping("/store/board/{page}")
	public ModelAndView store(@PathVariable int page,Model model) {
		
		
		ModelAndView mv=service.findAll(page);
		mv.setViewName("/store/list");
		
		
		return mv;
	}
	
	@GetMapping("/store/write")
	public String write() {
		return "/store/write";
	}
	
	@PostMapping("/store/write")
	public String write(BoardDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.write(dto);
		return "redirect:/store/board/1";
	}
	
	@GetMapping("/store/{no}")
	public String detail(@PathVariable int no, Model model) {
		BoardDto result=service.findOne(no);
		model.addAttribute("dto", result);
		return "/store/detail";
		
	}
	
	@GetMapping("/store/delete/{no}")
	public String delete(@PathVariable int no) {
		service.delete(no);
		return "redirect:/store/board/1";
	}
	
	@PostMapping("/store/edit")
	public String edit(BoardDto dto) {
		service.edit(dto);
		return "redirect:/store/"+dto.getNo();
	}
	


}
