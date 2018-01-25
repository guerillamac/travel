package org.guerillamac.endpoint;

import org.guerillamac.data.CountryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryEndpoint {

	@Autowired
	CountryFacade CountryFacade;

	@GetMapping("/{country}")
	public CountryInfo getCountryInfo(@PathVariable("country") String countryName){
		return CountryFacade.getCountryInfo();
	}


}
