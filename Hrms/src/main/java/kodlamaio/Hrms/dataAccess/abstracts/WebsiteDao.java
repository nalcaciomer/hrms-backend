package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Website;

public interface WebsiteDao extends JpaRepository<Website, Integer>{
	Website getByName(String name);
	List<Website> getAllByOrderByNameAsc();
	List<Website> getAllByOrderByNameDesc();
	boolean existsWebsiteByName(String name);
}
