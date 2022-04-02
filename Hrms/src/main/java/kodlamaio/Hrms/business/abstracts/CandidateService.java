package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	DataResult<Candidate> getByNationalIdentity(String nationalIdentity);
	DataResult<Candidate> getByEmail(String email);
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Result delete(Candidate candidate);
}
