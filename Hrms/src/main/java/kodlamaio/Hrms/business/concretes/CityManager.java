package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CityDao;
import kodlamaio.Hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Cities listed");
	}

	@Override
	public Result add(City city) {
		final Result result = BusinessRules.run(isExistsByName(city.getName()));
		
		if(!result.isSuccess()) {
			return result;
		}
		this.cityDao.save(city);
		
		return new SuccessResult("City added");
	}
	
	@Override
	public Result update(City city) {
		final Result result = BusinessRules.run(isExistsByName(city.getName()), isExistsById(city.getId()));
		
		if(!result.isSuccess()) {
			return result;
		}
		this.cityDao.save(city);
		
		return new SuccessResult("City updated");
	}

	@Override
	public Result delete(City city) {
		this.cityDao.delete(city);
		return new SuccessResult("City deleted");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.getById(id));
	}

	@Override
	public DataResult<City> getByName(String name) {
		return new SuccessDataResult<City>(this.cityDao.getByName(name));
	}

	@Override
	public DataResult<List<City>> getAllByNameAsc() {
		return new SuccessDataResult<List<City>>(this.cityDao.getAllByOrderByNameAsc());
	}

	@Override
	public DataResult<List<City>> getAllByNameDesc() {
		return new SuccessDataResult<List<City>>(this.cityDao.getAllByOrderByNameDesc());
	}
	
	private Result isExistsByName(String name) {
		return this.cityDao.existsCityByName(name) ? new ErrorResult("The city already exists")
				: new SuccessResult();
	}
	
	private Result isExistsById(int id) {
		return this.cityDao.existsById(id) ? new SuccessResult()
				: new ErrorResult("The city not exists") ;
	}

}
