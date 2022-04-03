package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CandidateCvImage;

public interface CandidateCvImageService {
	DataResult<List<CandidateCvImage>> getAll();
	DataResult<CandidateCvImage> getById(int id);
	Result add(MultipartFile multipartFile, int candidateId);
	Result update(MultipartFile multipartFile, int candidateId);
	Result delete(CandidateCvImage candidateCvImage);
	DataResult<List<CandidateCvImage>> getByCandidateCvId(int candidateCvId);
}
