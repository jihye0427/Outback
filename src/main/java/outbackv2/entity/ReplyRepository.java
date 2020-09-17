package outbackv2.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	
	@Query("select r from Reply r where b_no=:b_no")
	List<Reply> findAllByBNo(@Param("b_no")long b_no);

}
