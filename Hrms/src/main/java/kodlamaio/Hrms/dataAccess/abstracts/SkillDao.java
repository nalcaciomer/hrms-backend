package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{
	Skill getByName(String name);
	List<Skill> getAllByOrderByNameAsc();
	List<Skill> getAllByOrderByNameDesc();
	boolean existsSkillByName(String name);
}
