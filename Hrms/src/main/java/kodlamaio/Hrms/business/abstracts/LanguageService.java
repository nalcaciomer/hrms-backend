package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	DataResult<Language> getById(int id);
	Result add(Language language);
	Result update(Language language);
	Result delete(Language language);
	DataResult<Language> getByName(String name);
	DataResult<List<Language>> getAllByNameAsc();
	DataResult<List<Language>> getAllByNameDesc();
}
