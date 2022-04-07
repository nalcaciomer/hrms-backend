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

import kodlamaio.Hrms.business.abstracts.JobService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Job> getById(@RequestParam int id){
		return this.jobService.getById(id);
	}
	
	@GetMapping(value = "/getbyname")
	public DataResult<Job> getByName(@RequestParam String name){
		return this.jobService.getByName(name);
	}
	
	@PostMapping(value = "/add")
	public Result add(@Valid @RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	@PostMapping(value = "/update")
	public Result update(@Valid @RequestBody Job job) {
		return this.jobService.update(job);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Job job) {
		return this.jobService.delete(job);
	}
	
	@GetMapping(value = "/getallbynameasc")
	public DataResult<List<Job>> getAllByNameAsc(){
		return this.jobService.getAllByNameAsc();
	}
	
	@GetMapping(value = "/getallbynamedesc")
	public DataResult<List<Job>> getAllByNameDesc(){
		return this.jobService.getAllByNameDesc();
	}
	
}
