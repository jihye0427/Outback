package outbackv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class JpaMember {
	
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String pw;
	
	@Column(nullable = false)
	private String email;

	@Builder
	public JpaMember(String id, String name, String pw, String email) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
	}
	
	

}
