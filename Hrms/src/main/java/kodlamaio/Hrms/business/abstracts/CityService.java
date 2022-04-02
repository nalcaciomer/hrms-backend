package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
	Result add(City city);
	Result update(City city);
	Result delete(City city);
	DataResult<City> getByName(String name);
	DataResult<List<City>> getAllByNameAsc();
	DataResult<List<City>> getAllByNameDesc();
}
