package kodlamaio.Hrms.business.adapters.emailVerification;

import org.springframework.stereotype.Service;

//import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verify(String email) {
		// Fake Email Verification
		return new SuccessResult();
		//return new ErrorResult("Please verify your email");
	}
	
}
