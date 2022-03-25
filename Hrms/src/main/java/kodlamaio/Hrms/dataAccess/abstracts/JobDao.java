package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Optional<Job> findByName(String name);
}
