package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.EmployeeVerification;

public interface EmployeeVerificationDao extends JpaRepository<EmployeeVerification, Integer>{

}
