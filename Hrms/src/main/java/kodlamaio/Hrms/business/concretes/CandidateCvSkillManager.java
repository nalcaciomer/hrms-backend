package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvSkillDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvSkill;

@Service
public class CandidateCvSkillManager implements CandidateCvSkillService{
	
	private CandidateCvSkillDao candidateCvSkillDao;

	@Autowired
	public CandidateCvSkillManager(CandidateCvSkillDao candidateCvSkillDao) {
		this.candidateCvSkillDao = candidateCvSkillDao;
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getAll() {
		return new SuccessDataResult<List<CandidateCvSkill>>(this.candidateCvSkillDao.findAll());
	}

	@Override
	public DataResult<CandidateCvSkill> getById(int id) {
		return new SuccessDataResult<CandidateCvSkill>(this.candidateCvSkillDao.findById(id).get());
	}

	@Override
	public Result add(CandidateCvSkill candidateCvSkill) {
		this.candidateCvSkillDao.save(candidateCvSkill);
		return new SuccessResult("Skill added");
	}

	@Override
	public Result update(CandidateCvSkill candidateCvSkill) {
		this.candidateCvSkillDao.save(candidateCvSkill);
		return new SuccessResult("Skill updated");
	}

	@Override
	public Result delete(CandidateCvSkill candidateCvSkill) {
		this.candidateCvSkillDao.delete(candidateCvSkill);
		return new SuccessResult("Skill deleted");
	}

	@Override
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvSkill>>(this.candidateCvSkillDao.getByCandidateCv_Id(candidateCvId));
	}

}
