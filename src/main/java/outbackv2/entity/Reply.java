package outbackv2.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	@Column(nullable = false)
	private int board_no;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private String writer;
	@CreatedDate
	private LocalDateTime reg_date;
	
	@Builder
	public Reply(int board_no, String content, String writer) {
		this.board_no = board_no;
		this.content = content;
		this.writer = writer;
	}
	
	
	
	

	
	

}
