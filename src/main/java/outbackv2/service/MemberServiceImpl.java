package outbackv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import outbackv2.dto.JoinDto;
import outbackv2.dto.LoginDto;
import outbackv2.entity.JpaMember;
import outbackv2.entity.JpaMemberRepository;



@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private JpaMemberRepository repository;
	
	@Override
	public void save(JoinDto dto) {
		repository.save(dto.toEntity());
		
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
