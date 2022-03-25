package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	
}
