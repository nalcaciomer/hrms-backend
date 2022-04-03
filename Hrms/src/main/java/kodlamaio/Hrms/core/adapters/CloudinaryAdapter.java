package kodlamaio.Hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;

@Component
public class CloudinaryAdapter implements ImageService{
	
	private final Cloudinary cloudinary;
	
	public CloudinaryAdapter() {
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("cloud_name", "*****");
		valuesMap.put("api_key", "*****");
		valuesMap.put("api_secret", "*****");
		cloudinary = new Cloudinary(valuesMap);
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file = convert(multipartFile);
			Map<String, String> result = (Map<String, String>) cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<Map<String,String>>(result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorDataResult<Map<String,String>>("File didn't load!");
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(result);
	}
	
	private File convert(MultipartFile multipartFile) throws IOException{
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		return file;
	}
	
}
