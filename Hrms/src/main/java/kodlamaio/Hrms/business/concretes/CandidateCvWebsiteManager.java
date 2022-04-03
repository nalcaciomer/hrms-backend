package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvWebsiteService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvWebsiteDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvWebsite;

@Service
public class CandidateCvWebsiteManager implements CandidateCvWebsiteService{
	
	private CandidateCvWebsiteDao candidateCvWebsiteDao;
	
	@Autowired
	public CandidateCvWebsiteManager(CandidateCvWebsiteDao candidateCvWebsiteDao) {
		this.candidateCvWebsiteDao = candidateCvWebsiteDao;
	}

	@Override
	public DataResult<List<CandidateCvWebsite>> getAll() {
		return new SuccessDataResult<List<CandidateCvWebsite>>(this.candidateCvWebsiteDao.findAll());
	}

	@Override
	public DataResult<CandidateCvWebsite> getById(int id) {
		return new SuccessDataResult<CandidateCvWebsite>(this.candidateCvWebsiteDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCvWebsite candidateCvWebsite) {
		this.candidateCvWebsiteDao.save(candidateCvWebsite);
		return new SuccessResult("Website added");
	}

	@Override
	public Result update(CandidateCvWebsite candidateCvWebsite) {
		this.candidateCvWebsiteDao.save(candidateCvWebsite);
		return new SuccessResult("Website updated");
	}

	@Override
	public Result delete(CandidateCvWebsite candidateCvWebsite) {
		this.candidateCvWebsiteDao.delete(candidateCvWebsite);
		return new SuccessResult("Website deleted");
	}

	@Override
	public DataResult<List<CandidateCvWebsite>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvWebsite>>(this.candidateCvWebsiteDao.getByCandidateCv_Id(candidateCvId));
	}

}
