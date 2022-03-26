package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadlineDesc();
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_Id(int employerId);
	
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("update JobAdvertisement a set a.isActive = false where a.id = :id")
	void deactivateJobAdvertisement(int id);
}
