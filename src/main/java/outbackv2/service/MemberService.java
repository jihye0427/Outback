package outbackv2.service;

import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JoinDto;
import outbackv2.dto.LoginDto;

public interface MemberService {

	LoginDto login(LoginDto dto);

	ModelAndView save(JoinDto dto);

}
