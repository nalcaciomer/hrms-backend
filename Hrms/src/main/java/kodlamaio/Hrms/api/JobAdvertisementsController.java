package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<JobAdvertisement> getById(@RequestParam int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping(value = "/getallbyisactivetrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue(){
		return this.jobAdvertisementService.getAllByIsActiveTrue();
	}
	
	@GetMapping(value = "/getallbyisactivetrueorderbyapplicationdeadlinedesc")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueOrderByApplicationDeadlineDesc(){
		return this.jobAdvertisementService.getAllByIsActiveTrueOrderByApplicationDeadlineDesc();
	}
	
	@GetMapping(value = "/getallbyisactivetrueandemployer")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrueAndEmployer(int employerId){
		return this.jobAdvertisementService.getAllByIsActiveTrueAndEmployer(employerId);
	}
	
	@PostMapping(value = "/deactivate")
	Result deactivateJobAdvertisement(@RequestParam int id) {
		return this.jobAdvertisementService.deactivateJobAdvertisement(id);
	}
	
}
