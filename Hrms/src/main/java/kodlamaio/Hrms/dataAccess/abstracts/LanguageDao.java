package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
	Language getByName(String name);
	List<Language> getAllByOrderByNameAsc();
	List<Language> getAllByOrderByNameDesc();
	boolean existsLanguageByName(String name);
}
