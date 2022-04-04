package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.adapters.emailVerification.EmailVerificationService;
import kodlamaio.Hrms.core.adapters.PersonService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private PersonService personService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, PersonService personService,
			EmailVerificationService emailVerificationService) {
		this.candidateDao = candidateDao;
		this.personService = personService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public Result add(Candidate candidate){
		final Result result = BusinessRules.run(
				this.personService.checkIfRealPerson(candidate.getFirstName(), candidate.getLastName(),
						candidate.getDateOfBirth().getYear(), Long.parseLong(candidate.getNationalIdentity())),
				isEmailExists(candidate.getEmail()), isNationalIdentityExists(candidate.getNationalIdentity()),
				this.emailVerificationService.verify(candidate.getEmail()));

		if (!result.isSuccess()) {
			return result;
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added");
	}

	@Override
	public Result update(Candidate candidate) {
		final Result result = BusinessRules.run(isExistsById(candidate.getId()));

		if (!result.isSuccess()) {
			return result;
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate updated");
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Candidate deleted");
	}

	@Override
	public DataResult<Candidate> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByNationalIdentity(nationalIdentity));
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email));
	}

	private Result isNationalIdentityExists(String nationalIdentity) {
		return this.candidateDao.existsCandidateByNationalIdentity(nationalIdentity)
				? new ErrorResult("National identity is exists!")
				: new SuccessResult();
	}

	private Result isEmailExists(String email) {
		return this.candidateDao.existsCandidateByEmail(email) ? new ErrorResult("Email is exists!")
				: new SuccessResult();
	}

	private Result isExistsById(int id) {
		return this.candidateDao.existsById(id) ? new SuccessResult() : new ErrorResult("The candidate not exists");
	}

}
