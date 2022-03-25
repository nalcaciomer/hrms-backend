package kodlamaio.Hrms.business.adapters.mernis;

import kodlamaio.Hrms.core.utilities.results.Result;

public interface MernisCheckService {
	
	Result checkIfRealPerson(PersonForMernisCheckService person);
	
}
