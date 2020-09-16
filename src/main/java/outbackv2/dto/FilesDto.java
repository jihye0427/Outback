package outbackv2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import outbackv2.entity.Files;


@NoArgsConstructor
@Data
public class FilesDto {
	
	
	private String t_text;
	private String b_text;
	
	private String fileName;
	
	
	
	public Files toEntity() {
		return Files.builder().t_text(t_text).b_text(b_text).fileName(fileName).build();
		
	}


	

}
