package outbackv2.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.BoardDto;
import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyReqDto;

public interface StoreService {

	ModelAndView findAll(int page);

	void write(BoardDto dto);

	BoardDto findOne(int no);

	void delete(int no);

	void edit(BoardDto dto);

	int findList();



}
