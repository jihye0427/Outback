package outbackv2.service;

import outbackv2.dto.MailCheckReqDto;

public interface MailService {

	void mailsend(String email);

	String mailCheck(MailCheckReqDto dto);

}
