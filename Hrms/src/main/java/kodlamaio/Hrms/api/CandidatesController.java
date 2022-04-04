package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	@PostMapping(value = "/add")
	public Result add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Candidate candidate) {
		return this.candidateService.update(candidate);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Candidate candidate) {
		return this.candidateService.delete(candidate);
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Candidate> getById(int id){
		return this.candidateService.getById(id);
	}
	
	@GetMapping(value = "/getbynationalidentity")
	public DataResult<Candidate> getByNationalIdentity(@RequestParam String nationalIdentity){
		return this.candidateService.getByNationalIdentity(nationalIdentity);
	}
	
	@GetMapping(value = "/getbyemail")
	public DataResult<Candidate> getByEmail(@RequestParam String email){
		return this.candidateService.getByEmail(email);
	}
	
}
