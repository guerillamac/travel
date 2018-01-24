package org.guerillamac.services;

import org.guerillamac.entities.CurrencyApiUri;
import org.springframework.stereotype.Component;

@Component
public class FixerCurrencyApiUri implements CurrencyApiUri {
	private final static String URI_FIXER = "https://api.fixer.io/latest";

	@Override
	public String getUriOfCurrencyApi() {
		return URI_FIXER;
	}
}
