package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int id);
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(Employer employer);
	
	DataResult<Employer> getByEmail(String email);
	DataResult<Employer> getByCompanyName(String companyName);
	DataResult<Employer> getByWebsite(String website);
}
