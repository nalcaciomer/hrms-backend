package kodlamaio.Hrms.business.adapters.emailVerification;

import kodlamaio.Hrms.core.utilities.results.Result;

public interface EmailVerificationService {
	
	Result verify(String email);

}
