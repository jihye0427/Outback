package outbackv2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.Files;


@NoArgsConstructor
@Data
public class FilesResDto {
	

	private long no;
	private String fileName;
	private String t_text;
	private String b_text;
	private String used;
	
	public FilesResDto(Files fi) {
		this.no = fi.getNo();
		this.fileName = fi.getFileName();
		this.t_text = fi.getT_text();
		this.b_text = fi.getB_text();
		this.used = fi.getUsed();
	}
	
	
}
