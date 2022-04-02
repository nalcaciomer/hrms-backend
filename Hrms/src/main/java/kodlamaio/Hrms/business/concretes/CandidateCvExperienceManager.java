package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvExperience;

@Service
public class CandidateCvExperienceManager implements CandidateCvExperienceService{

	private CandidateCvExperienceDao candidateCvExperienceDao;
	
	@Autowired
	public CandidateCvExperienceManager(CandidateCvExperienceDao candidateCvExperienceDao) {
		this.candidateCvExperienceDao = candidateCvExperienceDao;
	}
	
	@Override
	public DataResult<List<CandidateCvExperience>> getAll() {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.findAll());
	}

	@Override
	public DataResult<CandidateCvExperience> getById(int id) {
		return new SuccessDataResult<CandidateCvExperience>(this.candidateCvExperienceDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCvExperience candidateCvExperience) {
		this.candidateCvExperienceDao.save(candidateCvExperience);
		return new SuccessResult("Experience added");
	}

	@Override
	public Result update(CandidateCvExperience candidateCvExperience) {
		this.candidateCvExperienceDao.save(candidateCvExperience);
		return new SuccessResult("Experience updated");
	}

	@Override
	public Result delete(CandidateCvExperience candidateCvExperience) {
		this.candidateCvExperienceDao.delete(candidateCvExperience);
		return new SuccessResult("Experience deleted");
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.getByCandidateCv_Id(candidateCvId));
	}

	@Override
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.getByCandidateCv_IdOrderByQuitDateDesc(candidateCvId));
	}

}
