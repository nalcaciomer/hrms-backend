package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping(value = "/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<City> getById(@RequestParam int id){
		return this.cityService.getById(id);
	}
	
	@GetMapping(value = "/getbyname")
	public DataResult<City> getByName(@RequestParam String name){
		return this.cityService.getByName(name);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody City city) {
		return this.cityService.update(city);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody City city) {
		return this.cityService.delete(city);
	}
	
	@GetMapping(value = "/getallbynameasc")
	public DataResult<List<City>> getAllByNameAsc(){
		return this.cityService.getAllByNameAsc();
	}
	
	@GetMapping(value = "/getallbynamedesc")
	public DataResult<List<City>> getAllByNameDesc(){
		return this.cityService.getAllByNameDesc();
	}
	
}
