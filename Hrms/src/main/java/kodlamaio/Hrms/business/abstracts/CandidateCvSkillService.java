package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvSkill;

public interface CandidateCvSkillService {
	DataResult<List<CandidateCvSkill>> getAll();
	DataResult<CandidateCvSkill> getById(int id);
	Result add(CandidateCvSkill candidateCvSkill);
	Result update(CandidateCvSkill candidateCvSkill);
	Result delete(CandidateCvSkill candidateCvSkill);
	DataResult<List<CandidateCvSkill>> getByCandidateCvId(int candidateCvId);
}
