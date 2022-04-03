package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SkillService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		this.skillService = skillService;
	}

	@GetMapping(value = "/getall")
	public DataResult<List<Skill>> getAll() {
		return this.skillService.getAll();
	}

	@GetMapping(value = "/getbyid")
	public DataResult<Skill> getById(@RequestParam int id) {
		return this.skillService.getById(id);
	}

	@GetMapping(value = "/getbyname")
	public DataResult<Skill> getByName(@RequestParam String name) {
		return this.skillService.getByName(name);
	}

	@PostMapping(value = "/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}

	@PostMapping(value = "/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}

	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Skill skill) {
		return this.skillService.delete(skill);
	}

	@GetMapping(value = "/getallbynameasc")
	public DataResult<List<Skill>> getAllByNameAsc() {
		return this.skillService.getAllByNameAsc();
	}

	@GetMapping(value = "/getallbynamedesc")
	public DataResult<List<Skill>> getAllByNameDesc() {
		return this.skillService.getAllByNameDesc();
	}
}
