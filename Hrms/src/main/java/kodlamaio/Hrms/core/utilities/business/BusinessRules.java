package kodlamaio.Hrms.core.utilities.business;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	public static Result run(final Result... logics) {
		for(final Result logic : logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
		}
		
		return new SuccessResult();
	}
	
}
