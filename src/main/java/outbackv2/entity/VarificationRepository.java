package outbackv2.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VarificationRepository extends JpaRepository<Varification, Long> {

	Optional<Varification> findByEmailAndCode(String email, String code);

	
}
