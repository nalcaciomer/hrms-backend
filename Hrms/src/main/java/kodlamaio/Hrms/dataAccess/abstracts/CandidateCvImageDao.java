package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageDao extends JpaRepository<CandidateCvImage, Integer>{
	List<CandidateCvImage> getByCandidateCv_Id(int candidateCvId);
}
