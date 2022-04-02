package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.WebsiteService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Website;

@RestController
@RequestMapping("/api/websites")
public class WebsitesController {
	
	private WebsiteService websiteService;
	
	@Autowired
	public WebsitesController(WebsiteService websiteService) {
		this.websiteService = websiteService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Website>> getAll(){
		return this.websiteService.getAll();
	}
	
	@GetMapping(value = "/getallbynameasc")
	public DataResult<List<Website>> getAllByNameAsc(){
		return this.websiteService.getAllByNameAsc();
	}
	
	@GetMapping(value = "/getallbynamedesc")
	public DataResult<List<Website>> getAllByNameDesc(){
		return this.websiteService.getAllByNameDesc();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Website> getById(int id){
		return this.websiteService.getById(id);
	}
	
	@GetMapping(value = "/getbyname")
	public DataResult<Website> getByName(@RequestParam String name){
		return this.websiteService.getByName(name);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Website website) {
		return this.websiteService.add(website);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Website website) {
		return this.websiteService.update(website);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(Website website) {
		return this.websiteService.delete(website);
	}
	
}
