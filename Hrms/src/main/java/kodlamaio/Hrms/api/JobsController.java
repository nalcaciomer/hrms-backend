package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobService;
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
	public List<Job> getAll(){
		return this.jobService.getAll();
	}
	
}
