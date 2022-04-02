package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceDao extends JpaRepository<CandidateCvExperience, Integer>{
	List<CandidateCvExperience> getByCandidateCv_Id(int candidateCvId);
	List<CandidateCvExperience> getByCandidateCv_IdOrderByQuitDateDesc(int candidateCvId);
}
