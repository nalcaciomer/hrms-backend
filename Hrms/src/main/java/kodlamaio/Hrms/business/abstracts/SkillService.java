package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
	DataResult<Skill> getById(int id);
	Result add(Skill skill);
	Result update(Skill skill);
	Result delete(Skill skill);
	DataResult<Skill> getByName(String name);
	DataResult<List<Skill>> getAllByNameAsc();
	DataResult<List<Skill>> getAllByNameDesc();
}
