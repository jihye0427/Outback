package outbackv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import outbackv2.dto.MailCheckReqDto;
import outbackv2.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	MailService service;
	
	@ResponseBody
	@PostMapping("/mail")
	public void mail(String email) {
		//System.out.println(email);
		service.mailsend(email);
	}
	
	@ResponseBody
	@PostMapping("/mail/check")
	public String check(MailCheckReqDto dto) {
	//	System.out.println(dto);
		//String mes=service.mailCheck(dto);
		return service.mailCheck(dto);
		
	}

}
