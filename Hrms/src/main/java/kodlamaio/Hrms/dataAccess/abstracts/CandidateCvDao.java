package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	CandidateCv getByCandidate_Id(int candidateId);
	boolean existsCandidateCvByCandidate_Id(int candidateId);
}
