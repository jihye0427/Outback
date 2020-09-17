package outbackv2.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import outbackv2.dto.JpaBoardDto;
import outbackv2.entity.JpaBoard;
import outbackv2.entity.JpaBoardRepository;
import outbackv2.util.PageMaker;



@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private JpaBoardRepository jpaBoardRepository;
	
	@Override
	public ModelAndView list(int page) {
	
		Sort sort=Sort.by(Direction.DESC, "no");
		int size=5;//한페이지에 표현할 게시글 수
		Pageable pageable=PageRequest.of(page-1, size, sort);
		Page<JpaBoard> pageInfo=jpaBoardRepository.findAll(pageable);
		List<JpaBoard> list= pageInfo.getContent(); //리턴 형식이 List
		PageMaker pageMaker =new PageMaker(page, pageInfo.getTotalPages());
		List<JpaBoardDto> result=new Vector<>();
		for(JpaBoard jpaboard:list) {
			JpaBoardDto dto= new JpaBoardDto(jpaboard);
			result.add(dto);
			
			
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", result);
		mv.addObject("pageMaker", pageMaker);
		
	
		return mv;
	}

	@Override
	public void write(JpaBoardDto dto) {
		jpaBoardRepository.save(dto.toEntity());
		
	}

	@Transactional
	@Override
	public JpaBoardDto detail(Long no) {
		JpaBoard result=jpaBoardRepository.findById(no)
				.map(e->e.countInc()) //조회수 증가
				.orElse(null);
		return new JpaBoardDto(result);
	}

	@Override
	public void delete(Long no) {
		jpaBoardRepository.deleteById(no);
		
	}

	@Transactional
	@Override
	public void edit(JpaBoardDto dto) {
		//원래 데이터 불러오기
		JpaBoard result=jpaBoardRepository.findById(dto.getNo()).orElse(null);
		//수정할 데이터 수정
		result.update(dto.getSubject(),dto.getContent());
		
		
	}


	

}
