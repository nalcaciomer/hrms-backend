package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Job getById(int id);
	Job getByName(String name);
	List<Job> getAllByOrderByNameAsc();
	List<Job> getAllByOrderByNameDesc();
	boolean existsJobByName(String name);
}
