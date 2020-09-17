package outbackv2.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyResDto;
import outbackv2.entity.Reply;
import outbackv2.entity.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository repository;

	@Override
	public void reg(ReplyDto dto) {
		repository.save(dto.toEntity());
		
		
	}

	@Override
	public List<ReplyResDto> findAllByB_no(long b_no) {
		List<Reply>result=repository.findAllByBNo(b_no);
		List<ReplyResDto> list= new Vector<>();
		for(Reply reply:result) {
			ReplyResDto dto=new ReplyResDto(reply);
			list.add(dto);
		}
		
		return list;
	}
	

}
