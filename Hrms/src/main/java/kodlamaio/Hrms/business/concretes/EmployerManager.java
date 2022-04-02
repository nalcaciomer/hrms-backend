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
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
	}

	@Override
	public Result add(Employer employer) {

		final Result result = BusinessRules.run(this.emailVerificationService.verify(employer.getEmail()),
				this.employeeVerificationService.verifyEmployer(employer), isEmailExists(employer.getEmail()),
				isCompanyNameExists(employer.getCompanyName()), isWebsiteExists(employer.getWebsite()),
				isPhoneNumberExists(employer.getPhoneNumber()));

		if (!result.isSuccess()) {
			return result;
		}

		this.employerDao.save(employer);
		return new SuccessResult("Employer added");
	}

	@Override
	public Result update(Employer employer) {
		final Result result = BusinessRules.run(isIdExists(employer.getId()));

		if (!result.isSuccess()) {
			return result;
		}

		this.employerDao.save(employer);
		return new SuccessResult("Employer updated");
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("Employer deleted");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email));
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.getByCompanyName(companyName));
	}

	@Override
	public DataResult<Employer> getByWebsite(String website) {
		return new SuccessDataResult<Employer>(this.employerDao.getByWebsite(website));
	}

	private Result isEmailExists(String email) {
		return this.employerDao.existsEmployerByEmail(email) ? new ErrorResult("Email is exists!")
				: new SuccessResult();
	}

	private Result isWebsiteExists(String website) {
		return this.employerDao.existsEmployerByWebsite(website) ? new ErrorResult("Website is exists!")
				: new SuccessResult();
	}

	private Result isCompanyNameExists(String companyName) {
		return this.employerDao.existsEmployerByCompanyName(companyName) ? new ErrorResult("Company name is exists!")
				: new SuccessResult();
	}

	private Result isPhoneNumberExists(String phoneNumber) {
		return this.employerDao.existsEmployerByPhoneNumber(phoneNumber) ? new ErrorResult("Phone number is exists!")
				: new SuccessResult();
	}

	private Result isIdExists(int id) {
		return this.employerDao.existsById(id) ? new SuccessResult() : new ErrorResult("The employer not exists");
	}

}
