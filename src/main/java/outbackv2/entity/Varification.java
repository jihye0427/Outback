package outbackv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Varification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vno;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String code;

	@Builder
	public Varification(String email, String code) {
		this.email = email;
		this.code = code;
	}
	
	
	

}
