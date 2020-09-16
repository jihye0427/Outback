package outbackv2.service;

import java.util.List;



import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.BoardDto;
import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyReqDto;
import outbackv2.mapper.StoreMapper;
import outbackv2.util.PageInfo;




@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreMapper mapper;
	
	
	
	@Override
	public ModelAndView findAll(int page) {

		//List<BoardDto> result=mapper.list();
		int limit=5;
		int offset=(page-1)*limit;
		RowBounds rowbounds=new RowBounds(offset, limit);
		
		//totalPage 필요
		int rowTotal=mapper.getCountOfRows(); //전체 게시글 수
		int totalPages=rowTotal/limit;
		if(rowTotal%limit>0)
			totalPages++;
		
		PageInfo pageInfo=new PageInfo(page, totalPages);
		ModelAndView mv=new ModelAndView();
		List<BoardDto> list=mapper.findAllDesc(rowbounds);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("list",list);
		
			
		
		return mv;
	}
	
	
	@Override
	public void write(BoardDto dto) {
		mapper.write(dto);
		
	}


	@Override
	public BoardDto findOne(int no) {
		BoardDto result=mapper.detail(no);
		return result;
	}


	@Override
	public void delete(int no) {
		mapper.delete(no);
	}


	@Override
	public void edit(BoardDto dto) {
		mapper.edit(dto);
		
	}


	@Override
	public int findList() {
		int result=mapper.count();
		return result;
	}











}
