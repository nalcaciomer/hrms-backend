package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
}
