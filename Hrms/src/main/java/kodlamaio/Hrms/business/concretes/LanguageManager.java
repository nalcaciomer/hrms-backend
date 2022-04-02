package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.LanguageService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.Hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.findById(id).get());
	}

	@Override
	public Result add(Language language) {
		final Result result = BusinessRules.run(isNameExists(language.getName()));
		
		if(!result.isSuccess()) {
			return result;
		}
		this.languageDao.save(language);
		return new SuccessResult("Language added");
	}

	@Override
	public Result update(Language language) {
		final Result result = BusinessRules.run(isNameExists(language.getName()), isIdExists(language.getId()));
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.languageDao.save(language);
		return new SuccessResult("Language updated");
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
		return new SuccessResult("Language deleted");
	}

	@Override
	public DataResult<Language> getByName(String name) {
		return new SuccessDataResult<Language>(this.languageDao.getByName(name));
	}

	@Override
	public DataResult<List<Language>> getAllByNameAsc() {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByOrderByNameAsc());
	}

	@Override
	public DataResult<List<Language>> getAllByNameDesc() {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllByOrderByNameDesc());
	}
	
	private Result isNameExists(String name) {
		return this.languageDao.existsLanguageByName(name) ? new ErrorResult("The language already exists")
				: new SuccessResult();
	}
	
	private Result isIdExists(int id) {
		return this.languageDao.existsById(id) ? new SuccessResult()
				: new ErrorResult("The language not exists") ;
	}

}
