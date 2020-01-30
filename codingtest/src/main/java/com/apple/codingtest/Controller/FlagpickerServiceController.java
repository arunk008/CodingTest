package com.apple.codingtest.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.codingtest.Service.FlagPickerService;
import com.apple.codingtest.entity.Continent;


@RestController
@RequestMapping("/flagpicker")
public class FlagpickerServiceController {

	@Autowired
	private FlagPickerService flagPickerService;
	
	//Get all continents
    @RequestMapping(method= RequestMethod.GET, value="/continent")
    public List<Continent> getAllContinetDetails(){
        return this.flagPickerService.getAllContinentAndCountryDetails();
    }
    //add Continent and Counties
    @RequestMapping(method= RequestMethod.POST, value="/continent")
    public HttpStatus createContinent(@Valid @RequestBody Continent continent) {
		return flagPickerService.addContinentAndRelatedCountriesInfo(continent) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }
    
    // return list of countries and flag
    @RequestMapping(value = "/continent/{continent_name}", method = RequestMethod.GET)
	public Object getCountriesByName(@PathVariable String continent_name) {
    	return flagPickerService.getForContinent(continent_name);
	}
   
    // return  flag
    @RequestMapping(value = "/countries/{countries_name}", method = RequestMethod.GET)
	public Object getCountriesById(@PathVariable String countries_name) {
    	return flagPickerService.getNameAndFlagForCountry(countries_name);
	}
    //update continent
    @RequestMapping(value = "/continent", method = RequestMethod.PUT)
	public HttpStatus updateContinentAndCountries(@RequestBody Continent continent) {
		return flagPickerService.updateContinent(continent) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
    
    
}
