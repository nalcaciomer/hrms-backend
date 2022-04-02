package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidatecvs")
public class CandidateCvsController {
	
	private CandidateCvService candidateCvService;
	
	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCv> getById(@RequestParam int id){
		return this.candidateCvService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.update(candidateCv);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.delete(candidateCv);
	}
	
	@GetMapping(value = "/getbycandidateid")
	public DataResult<CandidateCv> getByCandidateId(@RequestParam int candidateId){
		return this.candidateCvService.getByCandidateId(candidateId);
	}

}
