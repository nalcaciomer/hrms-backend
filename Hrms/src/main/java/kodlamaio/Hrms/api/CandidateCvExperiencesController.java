package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvExperienceService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvExperience;

@RestController
@RequestMapping("/api/candidatecvexperiences")
public class CandidateCvExperiencesController {
	
	private CandidateCvExperienceService candidateCvExperienceService;
	
	@Autowired
	public CandidateCvExperiencesController(CandidateCvExperienceService candidateCvExperienceService) {
		this.candidateCvExperienceService = candidateCvExperienceService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvExperience>> getAll(){
		return this.candidateCvExperienceService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvExperience> getById(@RequestParam int id){
		return this.candidateCvExperienceService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCvExperience candidateCvExperience) {
		return this.candidateCvExperienceService.add(candidateCvExperience);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCvExperience candidateCvExperience) {
		return this.candidateCvExperienceService.update(candidateCvExperience);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvExperience candidateCvExperience) {
		return this.candidateCvExperienceService.delete(candidateCvExperience);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvExperience>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvExperienceService.getByCandidateCvId(candidateCvId);
	}
	
	@GetMapping(value = "/getbycandidatecvidorderbyquitdatedesc")
	public DataResult<List<CandidateCvExperience>> getByCandidateCvIdOrderByDateOfGraduationDesc(@RequestParam int candidateCvId){
		return this.candidateCvExperienceService.getByCandidateCvIdOrderByQuitDateDesc(candidateCvId);
	}

}
