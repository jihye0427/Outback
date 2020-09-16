package outbackv2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import outbackv2.dto.BoardDto;
import outbackv2.dto.ReplyDto;
import outbackv2.dto.ReplyReqDto;

@Mapper
public interface StoreMapper {

	List<BoardDto> findAllDesc(RowBounds rowbounds);

	int getCountOfRows();

	void write(BoardDto dto);

	BoardDto detail(int no);

	void edit(BoardDto dto);

	void delete(int no);

	int count();

	

}
