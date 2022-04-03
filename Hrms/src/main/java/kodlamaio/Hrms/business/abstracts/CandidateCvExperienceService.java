package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceService {
	DataResult<List<CandidateCvExperience>> getAll();
	DataResult<CandidateCvExperience> getById(int id);
	Result add(CandidateCvExperience candidateCvExperience);
	Result update(CandidateCvExperience candidateCvExperience);
	Result delete(CandidateCvExperience candidateCvExperience);
	DataResult<List<CandidateCvExperience>> getByCandidateCvId(int candidateCvId);
	DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId);
}
