package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer getByEmail(String email);
	Employer getByCompanyName(String companyName);
	Employer getByWebsite(String website);
	boolean existsEmployerByCompanyName(String companyName);
	boolean existsEmployerByEmail(String email);
	boolean existsEmployerByWebsite(String website);
	boolean existsEmployerByPhoneNumber(String phoneNumber);
}
