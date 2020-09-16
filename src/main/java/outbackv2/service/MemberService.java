package outbackv2.service;

import outbackv2.dto.JoinDto;
import outbackv2.dto.LoginDto;

public interface MemberService {

	LoginDto login(LoginDto dto);

	void save(JoinDto dto);

}
