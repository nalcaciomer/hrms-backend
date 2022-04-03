package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCvWebsite;

public interface CandidateCvWebsiteDao extends JpaRepository<CandidateCvWebsite, Integer>{
	List<CandidateCvWebsite> getByCandidateCv_Id(int candidateCvId);
}
