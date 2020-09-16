package outbackv2.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	
	private int no;
	private int board_no;
	private String content;
	private String writer;
	private LocalDateTime reg_date;

}
