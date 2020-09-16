package outbackv2.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import outbackv2.dto.FilesDto;
import outbackv2.dto.FilesResDto;
import outbackv2.entity.Files;
import outbackv2.entity.FilesRepository;



@Service
public class FilesServiceImpl implements FilesService{

	@Autowired
	private FilesRepository repository;
	
	
	@Override
	public void save(FilesDto dto) {
		repository.save(dto.toEntity());
		
	}


	@Override
	public List<FilesResDto> findAll() {
		Sort sort=Sort.by("no");
		List<Files> result=repository.findAll(sort);
		List<FilesResDto>list=new Vector<>();
		for(Files fi:result) {
			FilesResDto dto=new FilesResDto(fi);
			list.add(dto);
			
		}
		return list;
	}


	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}




}
