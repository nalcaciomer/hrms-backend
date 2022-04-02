package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate getByNationalIdentity(String nationalIdentity);
	Candidate getByEmail(String email);
	boolean existsCandidateByNationalIdentity(String nationalIdentity);
	boolean existsCandidateByEmail(String email);
}
