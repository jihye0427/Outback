package outbackv2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JoinDto;
import outbackv2.dto.LoginDto;
import outbackv2.service.MemberService;



@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/user/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/user/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/user/signup")
	public ModelAndView join(JoinDto dto) {
		
		ModelAndView mv=service.save(dto);
		mv.setViewName("/member/login");
		
		return mv;
	}
	
	@PostMapping("/user/login")
	public ModelAndView login(LoginDto dto, HttpSession session) {
		LoginDto result=service.login(dto);
		ModelAndView mv= new ModelAndView();
		if(result==null) {
			//로그인실패
			//다시로그인페이지로
			mv.addObject("log_msg", "아이디나 패스워드가 일치하지 않습니다.");
			mv.setViewName("/member/login"); //html 리턴
		}else {
			
			session.setAttribute("user", result);
			mv.setViewName("redirect:/");
		}
		
		return mv;
		
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
		
	}
	
	

}