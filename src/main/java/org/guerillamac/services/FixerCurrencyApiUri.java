package org.guerillamac.services;

import org.guerillamac.entities.CurrencyApiUri;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class FixerCurrencyApiUri implements CurrencyApiUri {
	private final static String URI_FIXER = "https://api.fixer.io/latest";

	@Override
	public URI getUriOfCurrencyApi() throws URISyntaxException {
		return new URI(URI_FIXER);
	}
}
