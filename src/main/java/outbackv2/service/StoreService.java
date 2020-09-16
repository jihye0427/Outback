package outbackv2.service;

import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.BoardDto;

public interface StoreService {

	ModelAndView findAll(int page);

	void write(BoardDto dto);

	BoardDto findOne(int no);

	void delete(int no);

	void edit(BoardDto dto);





}
