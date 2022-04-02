package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceService {
	DataResult<List<CandidateCvExperience>> getAll();
	DataResult<CandidateCvExperience> getById(int id);
	Result add(CandidateCvExperience candidateCv);
	Result update(CandidateCvExperience candidateCv);
	Result delete(CandidateCvExperience candidateCv);
	DataResult<List<CandidateCvExperience>> getByCandidateCvId(int candidateCvId);
	DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByQuitDateDesc(int candidateCvId);
}
