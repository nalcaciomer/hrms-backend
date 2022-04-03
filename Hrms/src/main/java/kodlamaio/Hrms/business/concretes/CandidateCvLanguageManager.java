package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvLanguage;

@Service
public class CandidateCvLanguageManager implements CandidateCvLanguageService{
	
	private CandidateCvLanguageDao candidateCvLanguageDao;
	
	@Autowired
	public CandidateCvLanguageManager(CandidateCvLanguageDao candidateCvLanguageDao) {
		this.candidateCvLanguageDao = candidateCvLanguageDao;
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateCvLanguage>>(this.candidateCvLanguageDao.findAll());
	}

	@Override
	public DataResult<CandidateCvLanguage> getById(int id) {
		return new SuccessDataResult<CandidateCvLanguage>(this.candidateCvLanguageDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCvLanguage candidateCvLanguage) {
		this.candidateCvLanguageDao.save(candidateCvLanguage);
		return new SuccessResult("Language added");
	}

	@Override
	public Result update(CandidateCvLanguage candidateCvLanguage) {
		this.candidateCvLanguageDao.save(candidateCvLanguage);
		return new SuccessResult("Language updated");
	}

	@Override
	public Result delete(CandidateCvLanguage candidateCvLanguage) {
		this.candidateCvLanguageDao.delete(candidateCvLanguage);
		return new SuccessResult("Language deleted");
	}

	@Override
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvLanguage>>(this.candidateCvLanguageDao.getByCandidateCv_Id(candidateCvId));
	}

}
