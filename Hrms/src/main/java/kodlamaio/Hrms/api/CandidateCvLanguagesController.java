package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateCvLanguageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvLanguage;

@RestController
@RequestMapping("/api/candidatecvlanguages")
public class CandidateCvLanguagesController {
	
	private CandidateCvLanguageService candidateCvLanguageService;

	@Autowired
	public CandidateCvLanguagesController(CandidateCvLanguageService candidateCvLanguageService) {
		this.candidateCvLanguageService = candidateCvLanguageService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvLanguage>> getAll(){
		return this.candidateCvLanguageService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvLanguage> getById(@RequestParam int id){
		return this.candidateCvLanguageService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCvLanguage candidateCvLanguage) {
		return this.candidateCvLanguageService.add(candidateCvLanguage);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody CandidateCvLanguage candidateCvLanguage) {
		return this.candidateCvLanguageService.update(candidateCvLanguage);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvLanguage candidateCvLanguage) {
		return this.candidateCvLanguageService.delete(candidateCvLanguage);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvLanguage>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvLanguageService.getByCandidateCvId(candidateCvId);
	}
	
	

}
