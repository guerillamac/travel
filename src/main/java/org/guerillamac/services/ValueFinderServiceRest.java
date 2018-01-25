package org.guerillamac.services;

import org.guerillamac.clients.eurclient.ValueFinder;
import org.guerillamac.entities.CurrencyTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValueFinderServiceRest implements ValueFinderService {

	@Autowired
	private List<ValueFinder> valueFinders;

	//TODO make cache expiration interval
	@Override
	@Cacheable
	public CurrencyTable getValue() {
			return getValueFromApi();
	}

	private CurrencyTable getValueFromApi() {
		for (ValueFinder finder : valueFinders) {
			Optional<CurrencyTable> value = finder.findValues();
			if (value.isPresent())
				return value.get();
		}
		throw new RuntimeException("can't obtain currency from any source");
	}
}
