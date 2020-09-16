package outbackv2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.JpaMember;


@NoArgsConstructor
@Data
public class LoginDto {
	
	private String id;
	private String pw;
	
	
	public LoginDto(JpaMember member) {
		this.id=member.getId();
		this.pw=member.getPw();
	}

}
