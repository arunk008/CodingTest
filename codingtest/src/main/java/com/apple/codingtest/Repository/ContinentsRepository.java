package com.apple.codingtest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apple.codingtest.entity.Continent;



public interface ContinentsRepository  extends JpaRepository<Continent, Long>{

	@Query("Select cou.name,cou.flag from Countries cou ,Continent con where cou.continent = con.continent and con.continent=:continent_name ")
	List<String> findByContinentName(@Param("continent_name") String continent_name);


	
}
