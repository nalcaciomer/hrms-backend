package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvEducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvEducation;

@RestController
@RequestMapping("/api/candidatecveducations")
public class CandidateCvEducationsController {
	
	private CandidateCvEducationService candidateCvEducationService;
	
	@Autowired
	public CandidateCvEducationsController(CandidateCvEducationService candidateCvEducationService) {
		this.candidateCvEducationService = candidateCvEducationService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvEducation>> getAll(){
		return this.candidateCvEducationService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvEducation> getById(@RequestParam int id){
		return this.candidateCvEducationService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCvEducation candidateCv) {
		return this.candidateCvEducationService.add(candidateCv);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCvEducation candidateCv) {
		return this.candidateCvEducationService.update(candidateCv);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvEducation candidateCv) {
		return this.candidateCvEducationService.delete(candidateCv);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvEducation>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvEducationService.getByCandidateCvId(candidateCvId);
	}
	
	@GetMapping(value = "/getbycandidatecvidorderbydateofgraduationdesc")
	public DataResult<List<CandidateCvEducation>> getByCandidateCvIdOrderByDateOfGraduationDesc(@RequestParam int candidateCvId){
		return this.candidateCvEducationService.getByCandidateCvIdOrderByDateOfGraduationDesc(candidateCvId);
	}

}
