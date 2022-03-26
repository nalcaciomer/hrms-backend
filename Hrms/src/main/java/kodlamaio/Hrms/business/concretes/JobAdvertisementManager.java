package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Job advertisements listed");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get(), "Job advertisement listed");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("Job advertisement added");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(), "All active job advertisements listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineDesc(), "All active job advertisements listed order by application deadline descending");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_Id(employerId), "All active job advertisements of this employer are listed");
	}

	@Transactional
	@Override
	public Result deactivateJobAdvertisement(int id) {
		this.jobAdvertisementDao.deactivateJobAdvertisement(id);
		return new SuccessResult("The job advertisement deactivated");
	}

}
