package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvEducationDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvEducation;

@Service
public class CandidateCvEducationManager implements CandidateCvEducationService{

	private CandidateCvEducationDao candidateCvEducationDao;
	
	@Autowired
	public CandidateCvEducationManager(CandidateCvEducationDao candidateCvEducationDao) {
		this.candidateCvEducationDao = candidateCvEducationDao;
	}
	
	@Override
	public DataResult<List<CandidateCvEducation>> getAll() {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.findAll());
	}

	@Override
	public DataResult<CandidateCvEducation> getById(int id) {
		return new SuccessDataResult<CandidateCvEducation>(this.candidateCvEducationDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCvEducation candidateCvEducation) {
		this.candidateCvEducationDao.save(candidateCvEducation);
		return new SuccessResult("Education added");
	}

	@Override
	public Result update(CandidateCvEducation candidateCvEducation) {
		this.candidateCvEducationDao.save(candidateCvEducation);
		return new SuccessResult("Education updated");
	}

	@Override
	public Result delete(CandidateCvEducation candidateCvEducation) {
		this.candidateCvEducationDao.delete(candidateCvEducation);
		return new SuccessResult("Education deleted");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.getByCandidateCv_Id(candidateCvId), "All educational information of the candidate is listed");
	}

	@Override
	public DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvEducation>>(this.candidateCvEducationDao.getByCandidateCv_IdOrderByDateOfGraduationDesc(candidateCvId));
	}

}
