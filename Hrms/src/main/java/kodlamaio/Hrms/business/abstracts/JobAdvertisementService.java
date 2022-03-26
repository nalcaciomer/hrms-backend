package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getById(int id);
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByApplicationDeadlineDesc();
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndEmployer(int employerId);
	Result deactivateJobAdvertisement(int id);
}
