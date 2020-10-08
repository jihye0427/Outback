package outbackv2.dto;

import lombok.Data;
import outbackv2.entity.Varification;

@Data
public class MailCheckReqDto {
	private String email;
	private String code;
	
	public Varification toEntity() {
		return Varification.builder().code(code).email(email).build();
	}

}
