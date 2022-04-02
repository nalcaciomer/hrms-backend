package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	DataResult<List<CandidateCv>> getAll();
	DataResult<CandidateCv> getById(int id);
	Result add(CandidateCv candidateCv);
	Result update(CandidateCv candidateCv);
	Result delete(CandidateCv candidateCv);
	DataResult<CandidateCv> getByCandidateId(int candidateId);
}
