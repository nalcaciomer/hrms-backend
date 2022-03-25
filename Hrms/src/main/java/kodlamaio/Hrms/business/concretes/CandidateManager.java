package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.adapters.emailVerification.EmailVerificationService;
import kodlamaio.Hrms.business.adapters.mernis.MernisCheckService;
import kodlamaio.Hrms.business.adapters.mernis.PersonForMernisCheckService;
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
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService) {
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates listed");
	}

	@Override
	public Result add(Candidate candidate) {
		final Result result = BusinessRules.run(
				this.mernisCheckService.checkIfRealPerson(new PersonForMernisCheckService(
						Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName(),
						candidate.getLastName(), candidate.getDateOfBirth().getYear())),
				isEmailExists(candidate), 
				isNationalIdentityExists(candidate), 
				this.emailVerificationService.verify(candidate.getEmail()));

		if (!result.isSuccess()) {
			return result;
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added");
	}

	public Result isNationalIdentityExists(Candidate candidate) {
		return this.candidateDao.findByNationalIdentity(candidate.getNationalIdentity()).isEmpty() ? new SuccessResult()
				: new ErrorResult("National identity is exists!");
	}

	public Result isEmailExists(Candidate candidate) {
		return this.candidateDao.findByEmail(candidate.getEmail()).isEmpty() ? new SuccessResult()
				: new ErrorResult("Email is exists!");
	}
}
