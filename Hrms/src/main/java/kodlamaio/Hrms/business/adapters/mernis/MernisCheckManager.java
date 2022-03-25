package kodlamaio.Hrms.business.adapters.mernis;

import org.springframework.stereotype.Service;

//import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;

@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(final PersonForMernisCheckService person) {
		// Fake Mernis check
		return new SuccessResult();
		//return new ErrorResult("Not a valid person");
	}

}
