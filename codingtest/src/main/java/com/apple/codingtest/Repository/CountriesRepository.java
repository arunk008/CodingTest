package com.apple.codingtest.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;

import com.apple.codingtest.entity.Countries;


public interface CountriesRepository extends CrudRepository<Countries, Long>{

	@Query("Select flag from Countries c where c.name=:countries_id ")
	Object findByCountryName(@Param("countries_id") String countries_id);

	
}
