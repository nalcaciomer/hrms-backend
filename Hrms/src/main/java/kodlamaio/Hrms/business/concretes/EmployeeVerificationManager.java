package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeVerificationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.entities.concretes.EmployeeVerification;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService{

	@Override
	public DataResult<List<EmployeeVerification>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(EmployeeVerification employeeVerification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result verifyEmployer(Employer employer) {
		// Fake verification for now
		return new SuccessResult();
	}

}
