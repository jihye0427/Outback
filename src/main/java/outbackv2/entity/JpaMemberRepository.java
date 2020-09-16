package outbackv2.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<JpaMember, String>{

	JpaMember findByIdAndPw(String id, String pw);

}
