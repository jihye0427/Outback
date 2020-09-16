package outbackv2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@NoArgsConstructor
@Getter
@Entity
public class Files {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long no;
	
	@Column(nullable = false)
	String fileName;
	
	@Column(nullable = false)
	String t_text;
	
	@Column(nullable = false)
	String b_text;
	
	@Column(columnDefinition = " varchar(255) default 'on'")
	String used;

	
	@Builder
	public Files(String fileName, String t_text, String b_text, String used) {
		this.fileName = fileName;
		this.t_text = t_text;
		this.b_text = b_text;
		this.used = used;
	}

}
