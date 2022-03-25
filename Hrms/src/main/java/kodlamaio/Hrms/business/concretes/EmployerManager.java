package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeVerificationService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.adapters.emailVerification.EmailVerificationService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private EmployeeVerificationService employeeVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			EmployeeVerificationService employeeVerificationService) {
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.employeeVerificationService = employeeVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed");
	}

	@Override
	public Result add(Employer employer) {

		final Result result = BusinessRules.run(this.emailVerificationService.verify(employer.getEmail()),
				this.employeeVerificationService.verifyEmployer(employer), isEmailExists(employer));

		if (!result.isSuccess()) {
			return result;
		}

		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}

	public Result isEmailExists(Employer employer) {
		return this.employerDao.findByEmail(employer.getEmail()).isEmpty() ? new SuccessResult()
				: new ErrorResult("Email is exists!");
	}

}
