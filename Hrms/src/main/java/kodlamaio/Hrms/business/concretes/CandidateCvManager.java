package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.Hrms.entities.concretes.CandidateCv;

@Service
public class CandidateCvManager implements CandidateCvService {

	private CandidateCvDao candidateCvDao;

	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll());
	}

	@Override
	public DataResult<CandidateCv> getById(int id) {
		return new SuccessDataResult<CandidateCv>(this.candidateCvDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		final Result result = BusinessRules.run(isExistsByCandidateId(candidateCv.getCandidate().getId()));

		if (!result.isSuccess()) {
			return result;
		}

		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("Candidate cv added");
	}

	@Override
	public Result update(CandidateCv candidateCv) {
		final Result result = BusinessRules.run(isExistsById(candidateCv.getId()));

		if (!result.isSuccess()) {
			return result;
		}
		this.candidateCvDao.save(candidateCv);
		return new SuccessResult("Candidate cv updated");
	}

	@Override
	public Result delete(CandidateCv candidateCv) {
		this.candidateCvDao.delete(candidateCv);
		return new SuccessResult("Candidate cv deleted");
	}

	@Override
	public DataResult<CandidateCv> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateCv>(this.candidateCvDao.getByCandidate_Id(candidateId));
	}

	private Result isExistsByCandidateId(int candidateId) {
		return this.candidateCvDao.existsCandidateCvByCandidate_Id(candidateId)
				? new ErrorResult("The candidate already have a cv")
				: new SuccessResult();
	}

	private Result isExistsById(int id) {
		return this.candidateCvDao.existsById(id) ? new SuccessResult() : new ErrorResult("The cv not exists");
	}
}
