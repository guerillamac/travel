package org.guerillamac.data;

import org.guerillamac.entities.Country;
import org.guerillamac.entities.CurrencyCode;
import org.guerillamac.services.CurrencyCodeObtainer;
import org.guerillamac.services.NewsFeedService;
import org.guerillamac.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Currency;

public class CountryDaoMock implements CountryDao {

	private RecommendationService recommendationService;
	private NewsFeedService newsFeedService;
	private CurrencyCodeObtainer currencyCodeObtainer;

	@Override
	public Country getCountry(String name) {

		CurrencyCode currencyCodeForCountryName = currencyCodeObtainer.getCurrencyCodeForCountryName(name);

		Currency currency = Currency.getInstance(currencyCodeForCountryName.getCurrencyCode());
		Boolean isRecomended = recommendationService.getRecommendationForGivenCountry("name");
		String newsFeed = newsFeedService.getNewsFeed(name);

		Country country = new Country("Bambustan", currency, isRecomended, newsFeed);

		return country;
	}

	@Override
	public void updateCountry(int id) {
	}

	@Override
	public void deleteCountry(int id) {
	}


	@Autowired
	public void setNewsFeedService(NewsFeedService newsFeedService) {
		this.newsFeedService = newsFeedService;
	}

	@Autowired
	public void setCurrencyCodeObtainer(CurrencyCodeObtainer currencyCodeObtainer) {
		this.currencyCodeObtainer = currencyCodeObtainer;
	}

	@Autowired
	public void setRecommendationService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
}
