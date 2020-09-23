package outbackv2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JoinDto;
import outbackv2.dto.LoginDto;
import outbackv2.entity.JpaMember;
import outbackv2.entity.JpaMemberRepository;



@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private JpaMemberRepository repository;
	
	@Override
	public ModelAndView save(JoinDto dto) {
		Optional<JpaMember> result=repository.findById(dto.getId());
		ModelAndView mv=new ModelAndView();
		if(result.isPresent()) {
			mv.addObject("join_msg","이미 존재하는 id입니다");
		}else {
			repository.save(dto.toEntity());
			mv.addObject("msg", dto.getId());
			
		}
		
		return mv;
	
	}

	@Override
	public LoginDto login(LoginDto dto) {
		JpaMember member=repository.findByIdAndPw(dto.getId(),dto.getPw());
		if(member==null)
			return null;
		LoginDto log= new LoginDto(member);
		return log;
	}



}
