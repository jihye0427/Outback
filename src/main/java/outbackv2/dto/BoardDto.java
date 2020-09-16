package outbackv2.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int no;
	private String subject;
	private int count;
	private String writer;
	private String content;
	private LocalDateTime reg_date;
	private String user_ip;

}