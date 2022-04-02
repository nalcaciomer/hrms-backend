package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.WebsiteService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.WebsiteDao;
import kodlamaio.Hrms.entities.concretes.Website;

@Service
public class WebsiteManager implements WebsiteService{

	private WebsiteDao websiteDao;
	
	@Autowired
	public WebsiteManager(WebsiteDao websiteDao) {
		this.websiteDao = websiteDao;
	}
	
	@Override
	public DataResult<List<Website>> getAll() {
		return new SuccessDataResult<List<Website>>(this.websiteDao.findAll());
	}

	@Override
	public DataResult<List<Website>> getAllByNameAsc() {
		return new SuccessDataResult<List<Website>>(this.websiteDao.getAllByOrderByNameAsc());
	}

	@Override
	public DataResult<List<Website>> getAllByNameDesc() {
		return new SuccessDataResult<List<Website>>(this.websiteDao.getAllByOrderByNameDesc());
	}

	@Override
	public DataResult<Website> getById(int id) {
		return new SuccessDataResult<Website>(this.websiteDao.findById(id).get());
	}

	@Override
	public DataResult<Website> getByName(String name) {
		return new SuccessDataResult<Website>(this.websiteDao.getByName(name));
	}

	@Override
	public Result add(Website website) {
		final Result result = BusinessRules.run(isExistsByName(website.getName()));
		
		if(!result.isSuccess()) {
			return result;
		}
		this.websiteDao.save(website);
		return new SuccessResult("Website added");
	}

	@Override
	public Result update(Website website) {
		final Result result = BusinessRules.run(isExistsByName(website.getName()), isExistsById(website.getId()));
		
		if(!result.isSuccess()) {
			return result;
		}
		
		this.websiteDao.save(website);
		return new SuccessResult("Website updated");
	}

	@Override
	public Result delete(Website website) {
		this.websiteDao.delete(website);
		return new SuccessResult("Website deleted");
	}
	
	private Result isExistsByName(String name) {
		return this.websiteDao.existsWebsiteByName(name) ? new ErrorResult("The website already exists")
				: new SuccessResult();
	}
	
	private Result isExistsById(int id) {
		return this.websiteDao.existsById(id) ? new SuccessResult()
				: new ErrorResult("The website not exists") ;
	}

}
