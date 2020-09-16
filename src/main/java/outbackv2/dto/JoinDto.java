package outbackv2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.JpaMember;



@NoArgsConstructor
@Data
public class JoinDto {
	
	private String id;
	private String name;
	private String pw;
	private String email;
	
	
	
	public JpaMember toEntity() {
		
		return JpaMember.builder().id(id).pw(pw).name(name).email(email).build();
	}

}
