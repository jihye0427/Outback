package outbackv2.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	
	@Query("select r from Reply r where b_no=:b_no")
	List<Reply> findAllByBNo(@Param("b_no")long b_no);
	
	//Spring-Data-Jpa 에서 언더스코어 (_)가 프로퍼티를 찾기 위한 탐색 경로를 지정하는 예약어
	//메서드 쿼리 전략
	//조건컬럼이나 검색컬럼이라 정렬컬럼으로 사용하는 컬럼은 그냥 소문자로 만드는게 편리하다.
	//1. By 뒤에는 컬럼명... 첫글자 대문자로 표기해서 column명이 bno이면 Bno
	//2. 컬럼명을 카멜표명법이나 스네이크 표명법을 사용하지 말자

}
