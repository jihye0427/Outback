package outbackv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyResDto;
import outbackv2.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@ResponseBody
	@PostMapping("/reply/reg")
	public String reg(ReplyDto dto) {
		System.out.println(dto);
		service.reg(dto);
		return "등록완료";
		
	}
	
	
	
	@PostMapping("/reply/list")
	public String list(long b_no,Model model) {
		System.out.println(b_no);
		List<ReplyResDto> list=service.findAllByB_no(b_no);
		System.out.println(list.size());
		model.addAttribute("list", list);
	
		return "/board/replyList";
	}
	
	

	@GetMapping("/reply/delete/{r_no}")
	public String delete(@PathVariable long r_no) {
		service.delete(r_no);
		return "/board/replyList";
		
		
	}
	
	@GetMapping("/reply/edit/{r_no}")
	public String edit(@PathVariable long r_no,ReplyResDto dto) {
		service.edit(dto);
		return "/board/replyList";
	}

}
