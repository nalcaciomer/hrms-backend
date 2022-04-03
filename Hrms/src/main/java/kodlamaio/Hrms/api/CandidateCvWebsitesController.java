package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvWebsiteService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvWebsite;

@RestController
@RequestMapping("/api/candidatecvwebsites")
public class CandidateCvWebsitesController {
	private CandidateCvWebsiteService candidateCvWebsiteService;

	@Autowired
	public CandidateCvWebsitesController(CandidateCvWebsiteService candidateCvWebsiteService) {
		this.candidateCvWebsiteService = candidateCvWebsiteService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvWebsite>> getAll(){
		return this.candidateCvWebsiteService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvWebsite> getById(@RequestParam int id){
		return this.candidateCvWebsiteService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCvWebsite candidateCvWebsite) {
		return this.candidateCvWebsiteService.add(candidateCvWebsite);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCvWebsite candidateCvWebsite) {
		return this.candidateCvWebsiteService.update(candidateCvWebsite);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvWebsite candidateCvWebsite) {
		return this.candidateCvWebsiteService.delete(candidateCvWebsite);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvWebsite>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvWebsiteService.getByCandidateCvId(candidateCvId);
	}
}
