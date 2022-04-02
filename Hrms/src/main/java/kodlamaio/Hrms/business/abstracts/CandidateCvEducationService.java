package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvEducation;

public interface CandidateCvEducationService {
	DataResult<List<CandidateCvEducation>> getAll();
	DataResult<CandidateCvEducation> getById(int id);
	Result add(CandidateCvEducation candidateCv);
	Result update(CandidateCvEducation candidateCv);
	Result delete(CandidateCvEducation candidateCv);
	DataResult<List<CandidateCvEducation>> getByCandidateCvId(int candidateCvId);
	DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(int candidateCvId);

}
