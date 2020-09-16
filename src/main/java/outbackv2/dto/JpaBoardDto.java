package outbackv2.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.JpaBoard;


@NoArgsConstructor
@Data
public class JpaBoardDto {

	private Long no;
	private String subject;
	private int count;
	private String writer;
	private String content;
	private LocalDateTime reg_date;
	private String user_ip;
	
	//리스트에서 JpaBoard를 dto로 변환하는 과정
	public JpaBoardDto(JpaBoard jpaboard) {
		
		this.no = jpaboard.getNo();
		this.subject = jpaboard.getSubject();
		this.count = jpaboard.getCount();
		this.writer = jpaboard.getWriter();
		this.content = jpaboard.getContent();
		this.reg_date = jpaboard.getReg_date();
		this.user_ip = jpaboard.getUser_ip();
	}
	
	//글쓰기 처리에서 dto를 JpaBoard로 변환하는 과정
	public JpaBoard toEntity() {
		return JpaBoard.builder()
				.subject(subject)
				.content(content)
				.writer(writer)
				.user_ip(user_ip)
				.build();
		
	}
	

	

}
