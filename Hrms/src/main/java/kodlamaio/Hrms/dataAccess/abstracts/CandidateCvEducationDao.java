package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCvEducation;

public interface CandidateCvEducationDao extends JpaRepository<CandidateCvEducation, Integer>{
	List<CandidateCvEducation> getByCandidateCv_Id(int candidateCvId);
	List<CandidateCvEducation> getByCandidateCv_IdOrderByDateOfGraduationDesc(int candidateCvId);
}
