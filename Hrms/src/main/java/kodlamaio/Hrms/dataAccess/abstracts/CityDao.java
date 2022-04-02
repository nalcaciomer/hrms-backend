package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	City getByName(String name);
	List<City> getAllByOrderByNameAsc();
	List<City> getAllByOrderByNameDesc();
	boolean existsCityByName(String name);
}
