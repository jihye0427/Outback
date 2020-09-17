package outbackv2.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.Reply;
@NoArgsConstructor
@Data
public class ReplyResDto {
	private long r_no; //댓글 번호
	private String content;
	private String writer;
	private long b_no;
	private LocalDateTime reg_date;
	
	
	public ReplyResDto (Reply reply) {
		r_no=reply.getR_no();
		content=reply.getContent();
		writer=reply.getWriter();
		reg_date=reply.getReg_date();
		b_no=reply.getB_no();
	}

}
