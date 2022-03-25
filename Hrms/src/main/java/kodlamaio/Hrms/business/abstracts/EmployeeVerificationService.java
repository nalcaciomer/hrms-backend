package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.EmployeeVerification;
import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployeeVerificationService {
	
	DataResult<List<EmployeeVerification>> getAll();
	Result add(EmployeeVerification employeeVerification);
	Result verifyEmployer(Employer employer);
}
