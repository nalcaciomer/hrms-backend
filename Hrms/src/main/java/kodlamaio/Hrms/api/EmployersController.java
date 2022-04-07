package kodlamaio.Hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Employer> getById(@RequestParam int id){
		return this.employerService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@Valid @RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@PostMapping(value = "/update")
	public Result update(@Valid @RequestBody Employer employer) {
		return this.employerService.update(employer);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Employer employer) {
		return this.employerService.delete(employer);
	}
	
	@GetMapping(value = "/getbyemail")
	public DataResult<Employer> getByEmail(@RequestParam String email){
		return this.employerService.getByEmail(email);
	}
	
	@GetMapping(value = "/getbycompanyname")
	public DataResult<Employer> getByCompanyName(@RequestParam String companyName){
		return this.employerService.getByCompanyName(companyName);
	}
	
	@GetMapping(value = "/getbywebsite")
	public DataResult<Employer> getByWebsite(@RequestParam String website){
		return this.employerService.getByWebsite(website);
	}
	
}
