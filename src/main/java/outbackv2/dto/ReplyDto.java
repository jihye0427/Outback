package outbackv2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.Reply;
@NoArgsConstructor
@Data
public class ReplyDto {
	private String content;
	private String writer;
	private long b_no;
	
	
	public Reply toEntity() {
		return Reply.builder().content(content).writer(writer).b_no(b_no).build();
	}

}
