package com.apple.codingtest.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.codingtest.Repository.ContinentsRepository;
import com.apple.codingtest.Repository.CountriesRepository;
import com.apple.codingtest.entity.Continent;


@Service
public class FlagPickerService {

	
	private ContinentsRepository continentRepository;
	
	private CountriesRepository countriesRepository;
	
	@Autowired
	public FlagPickerService(ContinentsRepository continentRepository,CountriesRepository countriesRepository) {
		this.continentRepository = continentRepository;
		this.countriesRepository = countriesRepository;
	}
	
	
	@Transactional
	public List<Continent> getAllContinentAndCountryDetails() {
		return (List<Continent>)continentRepository.findAll();
    }
	
	
	
	@Transactional
	public boolean addContinentAndRelatedCountriesInfo(Continent continent) {
		return continentRepository.save(continent) != null;
	}	
	
	
	@Transactional
	public boolean updateContinent(Continent continent) {
		return continentRepository.save(continent) != null;
	}

	@Transactional
	public Object getNameAndFlagForCountry(String countries_name) {
		return countriesRepository.findByCountryName(countries_name);
		
	}

	@Transactional
	public Object getForContinent(String continent_name) {
		return continentRepository.findByContinentName(continent_name);
	}

	
}
