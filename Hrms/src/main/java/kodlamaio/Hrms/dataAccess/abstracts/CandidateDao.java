package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Optional<Candidate> findByNationalIdentity(String nationalIdentity);
	Optional<Candidate> findByEmail(String email);
}
