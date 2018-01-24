package org.guerillamac.entities;

import java.util.Currency;
import java.util.Map;
import java.util.Set;

public class FixerCurrencyTable implements CurrencyTable {

	private Map<Currency, CurrencyValue> currencyValuePairs;
	private Currency refCurrency;

	public FixerCurrencyTable(Map<Currency, CurrencyValue> currencyValuePairs, Currency refCurrency) {
		this.currencyValuePairs = currencyValuePairs;
		this.refCurrency = refCurrency;
	}

	public Currency getRefCurrency() {
		return refCurrency;
	}

	public Set<Map.Entry<Currency, CurrencyValue>> entrySet(){
		return currencyValuePairs.entrySet();
	}

	@Override
	public CurrencyValue getValueFor(Currency currency) {
		return currencyValuePairs.get(currency);
	}

}
