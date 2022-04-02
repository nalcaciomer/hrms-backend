package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	Employee getByEmail(String email);
	List<Employee> getByFirstNameAndLastName(String firstName, String lastName);
	boolean existsEmployeeByEmail(String email);
}
