package org.guerillamac.services;

import org.guerillamac.clients.eurclient.ValueFinder;
import org.guerillamac.entities.CurrencyValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Currency;

public class ValueObtainer {

	@Autowired
	ValueFinder finder;

	public CurrencyValue findValueInEuro(Currency currency) {

		return finder.findValues().getValueFor(Currency.getInstance("USD"));
	}
}
