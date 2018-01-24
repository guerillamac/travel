package org.guerillamac.services;

import org.guerillamac.InjectLogger;
import org.guerillamac.entities.CurrencyApiUri;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;


public class EcbCurrencyApiUri implements CurrencyApiUri {

	@InjectLogger
	Logger logger;

	@Override
	public String getUriOfCurrencyApi() {
		return "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	}
}
