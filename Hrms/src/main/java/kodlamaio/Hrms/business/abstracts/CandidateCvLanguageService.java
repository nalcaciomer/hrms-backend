package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvLanguage;

public interface CandidateCvLanguageService {
	DataResult<List<CandidateCvLanguage>> getAll();
	DataResult<CandidateCvLanguage> getById(int id);
	Result add(CandidateCvLanguage candidateCvLanguage);
	Result update(CandidateCvLanguage candidateCvLanguage);
	Result delete(CandidateCvLanguage candidateCvLanguage);
	DataResult<List<CandidateCvLanguage>> getByCandidateCvId(int candidateCvId);
}
