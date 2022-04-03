package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CandidateCvImageService;
import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.adapters.ImageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateCvImageDao;
import kodlamaio.Hrms.entities.concretes.CandidateCvImage;

@Service
public class CandidateCvImageManager implements CandidateCvImageService{
	
	private CandidateCvImageDao candidateCvImageDao;
	private ImageService imageService;
	private CandidateService candidateService;
	
	@Autowired
	public CandidateCvImageManager(CandidateCvImageDao candidateCvImageDao, ImageService imageService, CandidateService candidateService) {
		this.candidateCvImageDao = candidateCvImageDao;
		this.imageService = imageService;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<CandidateCvImage>> getAll() {
		return new SuccessDataResult<List<CandidateCvImage>>(this.candidateCvImageDao.findAll());
	}

	@Override
	public DataResult<CandidateCvImage> getById(int id) {
		return new SuccessDataResult<CandidateCvImage>(this.candidateCvImageDao.findById(id).get());
	}

	@Override
	public Result add(MultipartFile multipartFile, int candidateId) {
		var result = this.imageService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult("Image upload failed!");
		}
		var candidate = this.candidateService.getById(candidateId).getData();
		CandidateCvImage candidateCvImage = new CandidateCvImage();
		candidateCvImage.setCandidateCv(candidate.getCandidateCv());;
		candidateCvImage.setUrl(result.getData().get("url"));
		
		
		this.candidateCvImageDao.save(candidateCvImage);
		return new SuccessResult("Image added");
	}

	@Override
	public Result update(MultipartFile multipartFile, int id) {
		var result = this.imageService.upload(multipartFile);
		if (!result.isSuccess()) {
			return new ErrorResult("Image upload failed!");
		}
		var candidate = this.candidateService.getById(id).getData();
		CandidateCvImage candidateCvImage = new CandidateCvImage();
		candidateCvImage.setCandidateCv(candidate.getCandidateCv());;
		candidateCvImage.setUrl(result.getData().get("url"));
		
		
		this.candidateCvImageDao.save(candidateCvImage);
		return new SuccessResult("Image updated");
	}

	@Override
	public Result delete(CandidateCvImage candidateCvImage) {
		this.candidateCvImageDao.delete(candidateCvImage);
		return new SuccessResult("Image deleted");
	}

	@Override
	public DataResult<List<CandidateCvImage>> getByCandidateCvId(int candidateCvId) {
		return new SuccessDataResult<List<CandidateCvImage>>(this.candidateCvImageDao.getByCandidateCv_Id(candidateCvId));
	}

}
