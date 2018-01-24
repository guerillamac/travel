package org.guerillamac.services;

import org.guerillamac.entities.CurrencyCode;

public interface CurrencyCodeObtainer {

	CurrencyCode getCurrencyCodeForCountryName(String countryName);
}
