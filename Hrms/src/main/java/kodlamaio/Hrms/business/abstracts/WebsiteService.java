package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Website;

public interface WebsiteService {
	DataResult<List<Website>> getAll();
	DataResult<List<Website>> getAllByNameAsc();
	DataResult<List<Website>> getAllByNameDesc();
	DataResult<Website> getById(int id);
	DataResult<Website> getByName(String name);
	Result add(Website website);
	Result update(Website website);
	Result delete(Website website);
}
