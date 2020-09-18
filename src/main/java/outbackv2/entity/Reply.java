package outbackv2.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long r_no; //댓글 번호
	
	@Column(nullable = false)
	String content;
	
	@Column(nullable = false)
	String writer;
	
	@CreatedDate
	LocalDateTime reg_date;
	
	long b_no; //게시글 번호

	@Builder
	public Reply(String content, String writer, long b_no) {
		super();
		this.content = content;
		this.writer = writer;
		this.b_no = b_no;
	}

	public Reply update(String content) {
		this.content=content;
		return this;
		
	}
	
	
	

}
