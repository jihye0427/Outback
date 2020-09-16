package outbackv2.dto;

import java.time.LocalDateTime;

import lombok.Data;
import outbackv2.entity.Reply;

@Data
public class ReplyReqDto {
	
	private int no;
	private int board_no;
	private String content;
	private String writer;
	private LocalDateTime reg_date;
	
	public Reply toEntity() {
		return Reply.builder().board_no(board_no).content(content).writer(writer).build();
		
	}

}
