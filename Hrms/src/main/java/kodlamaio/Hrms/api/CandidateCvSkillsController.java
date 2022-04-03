package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvSkillService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvSkill;

@RestController
@RequestMapping("/api/candidatecvskills")
public class CandidateCvSkillsController {
	private CandidateCvSkillService candidateCvSkillService;

	@Autowired
	public CandidateCvSkillsController(CandidateCvSkillService candidateCvSkillService) {
		this.candidateCvSkillService = candidateCvSkillService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvSkill>> getAll(){
		return this.candidateCvSkillService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvSkill> getById(@RequestParam int id){
		return this.candidateCvSkillService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCvSkill candidateCvSkill) {
		return this.candidateCvSkillService.add(candidateCvSkill);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCvSkill candidateCvSkill) {
		return this.candidateCvSkillService.update(candidateCvSkill);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvSkill candidateCvSkill) {
		return this.candidateCvSkillService.delete(candidateCvSkill);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvSkill>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvSkillService.getByCandidateCvId(candidateCvId);
	}
}
