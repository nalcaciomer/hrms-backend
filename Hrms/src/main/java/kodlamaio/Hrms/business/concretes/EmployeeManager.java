package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.core.utilities.business.BusinessRules;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.Hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.findById(id).get());
	}

	@Override
	public Result add(Employee employee) {
		final Result result = BusinessRules.run(
				isEmailExists(employee.getEmail()));

		if (!result.isSuccess()) {
			return result;
		}
		
		this.employeeDao.save(employee);
		return new SuccessResult();
	}

	@Override
	public Result update(Employee employee) {
		final Result result = BusinessRules.run(isExistsById(employee.getId()));
		
		if(!result.isSuccess()) {
			return result;
		}
		this.employeeDao.save(employee);
		return new SuccessResult();
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult();
	}

	@Override
	public DataResult<Employee> getByEmail(String email) {
		return new SuccessDataResult<Employee>(this.employeeDao.getByEmail(email));
	}

	@Override
	public DataResult<List<Employee>> getByFirstNameAndLastName(String firstName, String lastName) {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.getByFirstNameAndLastName(firstName, lastName));
	}
	
	private Result isEmailExists(String email) {
		return this.employeeDao.existsEmployeeByEmail(email) ? new ErrorResult("Email is exists!")
				: new SuccessResult();
	}

	private Result isExistsById(int id) {
		return this.employeeDao.existsById(id) ? new SuccessResult()
				: new ErrorResult("The employee not exists") ;
	}
	
}
