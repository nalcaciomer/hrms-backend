package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCvSkill;

public interface CandidateCvSkillDao extends JpaRepository<CandidateCvSkill, Integer>{
	List<CandidateCvSkill> getByCandidateCv_Id(int candidateCvId);
}
