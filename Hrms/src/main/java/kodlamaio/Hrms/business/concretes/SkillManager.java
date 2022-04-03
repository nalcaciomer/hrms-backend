package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SkillService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.Hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillDao.findById(id).get());
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill added");
	}

	@Override
	public Result update(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill updated");
	}

	@Override
	public Result delete(Skill skill) {
		this.skillDao.delete(skill);
		return new SuccessResult("Skill deleted");
	}

	@Override
	public DataResult<Skill> getByName(String name) {
		return new SuccessDataResult<Skill>(this.skillDao.getByName(name));
	}

	@Override
	public DataResult<List<Skill>> getAllByNameAsc() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getAllByOrderByNameAsc());
	}

	@Override
	public DataResult<List<Skill>> getAllByNameDesc() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getAllByOrderByNameDesc());
	}

}
