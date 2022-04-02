package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Job;

public interface JobService {
	
	DataResult<List<Job>> getAll();
	DataResult<List<Job>> getAllByNameAsc();
	DataResult<List<Job>> getAllByNameDesc();
	DataResult<Job> getById(int id);
	DataResult<Job> getByName(String name);
	Result add(Job job);
	Result update(Job job);
	Result delete(Job job);
	
}
