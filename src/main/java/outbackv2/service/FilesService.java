package outbackv2.service;

import java.util.List;

import outbackv2.dto.FilesDto;
import outbackv2.dto.FilesResDto;

public interface FilesService {

	List<FilesResDto> findAll();

	void save(FilesDto dto);

	void delete(Long no);

}
