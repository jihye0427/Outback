package outbackv2.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "jpa_board")
@Entity
public class JpaBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable = false)
	private String subject;
	
	private int count;
	@Column(nullable = false)
	private String writer;
	@Column(columnDefinition = "text", nullable = false)
	private String content;
	@CreatedDate
	private LocalDateTime reg_date;
	@Column(nullable = false)
	private String user_ip;
	
	@Builder
	public JpaBoard(Long no,String subject, String writer, String content, String user_ip) {
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.user_ip = user_ip;
		
	}

	public JpaBoard update(String subject, String content) {
		this.subject=subject;
		this.content=content;
		return this;

	}

	public JpaBoard countInc() {
		this.count++;
		return this;
	}
}