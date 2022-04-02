package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.LanguageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Language> getById(int id){
		return this.languageService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Language language) {
		return this.languageService.delete(language);
	}
	
	@GetMapping(value = "/getbyname")
	public DataResult<Language> getByName(@RequestParam String name){
		return this.languageService.getByName(name);
	}
	
	@GetMapping(value = "/getallbynameasc")
	public DataResult<List<Language>> getAllByNameAsc(){
		return this.languageService.getAllByNameAsc();
	}
	
	@GetMapping(value = "/getallbynamedesc")
	public DataResult<List<Language>> getAllByNameDesc(){
		return this.languageService.getAllByNameDesc();
	}
	
}
