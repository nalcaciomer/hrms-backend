package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvImage;

@RestController
@RequestMapping("/api/candidatecvimages")
public class CandidateCvImagesController {
	
	private CandidateCvImageService candidateCvImageService;
	
	@Autowired
	public CandidateCvImagesController(CandidateCvImageService candidateCvImageService) {
		this.candidateCvImageService = candidateCvImageService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<CandidateCvImage>> getAll(){
		return this.candidateCvImageService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<CandidateCvImage> getById(@RequestParam int id){
		return this.candidateCvImageService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestPart("file") MultipartFile candidateCvImage, @RequestParam int candidateId) {
		return this.candidateCvImageService.add(candidateCvImage, candidateId);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestPart("file") MultipartFile candidateCvImage, @RequestParam int candidateId) {
		return this.candidateCvImageService.update(candidateCvImage, candidateId);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody CandidateCvImage candidateCvImage) {
		return this.candidateCvImageService.delete(candidateCvImage);
	}
	
	@GetMapping(value = "/getbycandidatecvid")
	public DataResult<List<CandidateCvImage>> getByCandidateCvId(@RequestParam int candidateCvId){
		return this.candidateCvImageService.getByCandidateCvId(candidateCvId);
	}

}
