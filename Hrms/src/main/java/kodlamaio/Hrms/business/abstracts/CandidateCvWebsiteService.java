package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvWebsite;

public interface CandidateCvWebsiteService {
	DataResult<List<CandidateCvWebsite>> getAll();
	DataResult<CandidateCvWebsite> getById(int id);
	Result add(CandidateCvWebsite candidateCvWebsite);
	Result update(CandidateCvWebsite candidateCvWebsite);
	Result delete(CandidateCvWebsite candidateCvWebsite);
	DataResult<List<CandidateCvWebsite>> getByCandidateCvId(int candidateCvId);
}
