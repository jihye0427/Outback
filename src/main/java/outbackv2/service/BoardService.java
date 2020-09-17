package outbackv2.service;

import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JpaBoardDto;

public interface BoardService {

	ModelAndView list(int page);

	void write(JpaBoardDto dto);

	JpaBoardDto detail(Long no);

	void delete(Long no);

	void edit(JpaBoardDto dto);



}
