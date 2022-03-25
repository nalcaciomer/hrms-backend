package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Optional<Employer> findByEmail(String email);
}
