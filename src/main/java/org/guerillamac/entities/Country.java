package org.guerillamac.entities;

import java.util.Currency;

public class Country {

	public Country(String name, Currency currency , Boolean isRecomended, String newsFeed) {
		this.name = name;
		this.currency = currency;
		this.isRecomended = isRecomended;
		this.newsFeed = newsFeed;
	}

	private String name;
	private Currency currency;
	private Boolean isRecomended;
	private String newsFeed;

	public String getName() {
		return name;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Boolean getRecomended() {
		return isRecomended;
	}

	public String getNewsFeed() {
		return newsFeed;
	}
//TODO make newsFeed object
}
