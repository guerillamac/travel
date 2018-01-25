package org.guerillamac.endpoint;

import org.guerillamac.data.CountryInfo;
import org.guerillamac.services.ValueFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryFacade {

	@Autowired
	private ValueFinderService service;

	public CountryInfo getCountryInfo(){
		return new CountryInfo();
	}

}
