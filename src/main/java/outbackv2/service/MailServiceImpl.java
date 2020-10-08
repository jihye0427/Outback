package outbackv2.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import outbackv2.dto.MailCheckReqDto;
import outbackv2.entity.Varification;
import outbackv2.entity.VarificationRepository;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	VarificationRepository repository;

	@Override
	public void mailsend(String email) {
		
		SimpleMailMessage message= new SimpleMailMessage();
		String code=createKey();
		message.setFrom("jihye6599@gmail.com"); //보내는 사람
		message.setTo(email); //받는사람
		message.setSubject("회원가입을 위한 인증메일입니다.");
		//message.setText("회원가입을 위한 인증번호입니다. 인증번호 : "+System.nanoTime());
		message.setText("회원가입을 위한 인증번호입니다. 인증번호 : "+code);
		
		sender.send(message);
		
		//entity 객체 생성
		Varification entity=new Varification(email,code);
		repository.save(entity);
		
	}

	private String createKey() {
		StringBuffer key=new StringBuffer();
		Random r=new Random();
		for(int i=0; i<6; i++) {
			int idx=r.nextInt(3); //0부터 2까지
			
			switch(idx) {
			case 0: //영문자 소문자 //a(97)~z(122)
				key.append((char)(r.nextInt(26)+97)); //0+97 : a
				break;
			case 1: //영문자 대문자
				key.append((char)(r.nextInt(26)+65)); //0+65 : A
				break;
			case 2: //숫자
				key.append(r.nextInt(10)); //0~9
			
			}
		}
		return key.toString();
	}

	@Override
	public String mailCheck(MailCheckReqDto dto) {
		Optional<Varification> op=repository.findByEmailAndCode(dto.getEmail(),dto.getCode());
		if(op.isPresent()) {
			//Varification entity=op.get();
			return ("인증되었습니다.");
		}else {
			return ("인증번호가 다릅니다.");
		}
		
	}

}
