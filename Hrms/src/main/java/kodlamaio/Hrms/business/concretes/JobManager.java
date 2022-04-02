package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobDao;
import kodlamaio.Hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Jobs listed");
	}
	
	@Override
	public DataResult<Job> getById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.getById(id), "Job listed");
	}

	@Override
	public DataResult<Job> getByName(String name) {
		return new SuccessDataResult<Job>(this.jobDao.getByName(name), "Job listed");
	}

	@Override
	public Result add(Job job) {

		final Result result = BusinessRules.run(isExistsByName(job.getName()));
		
		if(!result.isSuccess()) {
			return result;
		}

		this.jobDao.save(job);
		return new SuccessResult("Job added");
	}

	@Override
	public Result update(Job job) {
		final Result result = BusinessRules.run(isExistsById(job.getId()), isExistsByName(job.getName()));
		
		if(!result.isSuccess()) {
			return result;
		}

		this.jobDao.save(job);
		return new SuccessResult("Job updated");
	}

	@Override
	public Result delete(Job job) {
		this.jobDao.deleteById(job.getId());
		return new SuccessResult("Job deleted");
	}

	@Override
	public DataResult<List<Job>> getAllByNameAsc() {
		return new SuccessDataResult<List<Job>>(this.jobDao.getAllByOrderByNameAsc());
	}

	@Override
	public DataResult<List<Job>> getAllByNameDesc() {
		return new SuccessDataResult<List<Job>>(this.jobDao.getAllByOrderByNameDesc());
	}
	
	private Result isExistsByName(String name) {
		return this.jobDao.existsJobByName(name) ? new ErrorResult("The job already exists")
				: new SuccessResult();
	}
	
	private Result isExistsById(int id) {
		return this.jobDao.existsById(id) ? new SuccessResult()
				: new ErrorResult("The job not exists") ;
	}

}
