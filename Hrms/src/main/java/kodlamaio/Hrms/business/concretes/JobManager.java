package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobService;
import kodlamaio.Hrms.dataAccess.abstracts.JobDao;
import kodlamaio.Hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{
	
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public List<Job> getAll() {
		return this.jobDao.findAll();
	}

}
