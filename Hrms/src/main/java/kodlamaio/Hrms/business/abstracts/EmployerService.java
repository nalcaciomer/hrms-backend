package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);

}
