package kodlamaio.Hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@GetMapping(value = "/getbyid")
	public DataResult<Employee> getById(@RequestParam int id){
		return this.employeeService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
	
	@PostMapping(value = "/update")
	public Result update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}
	
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Employee employee) {
		return this.employeeService.delete(employee);
	}
	
	@GetMapping(value = "/getbyemail")
	public DataResult<Employee> getByEmail(@RequestParam String email){
		return this.employeeService.getByEmail(email);
	}
	
	@GetMapping(value = "/getbyfirstnameandlastname")
	public DataResult<List<Employee>> getByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
		return this.employeeService.getByFirstNameAndLastName(firstName, lastName);
	}

}
