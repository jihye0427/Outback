package outbackv2.service;

import java.util.List;

import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyResDto;

public interface ReplyService {

	void reg(ReplyDto dto);

	List<ReplyResDto> findAllByB_no(long b_no);

	void delete(long r_no);

	void edit(ReplyResDto dto);

}
