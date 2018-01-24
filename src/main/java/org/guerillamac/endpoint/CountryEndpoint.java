package org.guerillamac.endpoint;

import org.guerillamac.data.CountryDaoMock;
import org.guerillamac.entities.Country;
import org.guerillamac.entities.CurrencyCode;
import org.guerillamac.services.CurrencyCodeObtainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
public class CountryEndpoint {

//	@Autowired
	private CountryDaoMock dao = new CountryDaoMock();

	@GetMapping("/{country}")
	public Country getCountryInfo(@PathVariable("country") String countryName){

		return dao.getCountry(countryName);
//		return new Country(countryName, Currency.getInstance("USD"),true,"NEWS_FEED");
	}

	private void setUp(){
		dao.setCurrencyCodeObtainer(countryName -> new CurrencyCode("USD"));
//	TODO	dao.setNewsFeedService();
//		dao.setRecommendationService();
	}


}
