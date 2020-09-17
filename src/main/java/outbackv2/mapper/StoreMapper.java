package outbackv2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import outbackv2.dto.BoardDto;

@Mapper
public interface StoreMapper {

	List<BoardDto> findAllDesc(RowBounds rowbounds);

	int getCountOfRows();

	void write(BoardDto dto);

	BoardDto detail(int no);

	void edit(BoardDto dto);

	void delete(int no);

	void count(int no);



	

}
