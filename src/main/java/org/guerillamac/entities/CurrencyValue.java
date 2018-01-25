package org.guerillamac.entities;

public class CurrencyValue {
	private Double currencyValue;

	public CurrencyValue(Double currencyValue) {
		this.currencyValue = currencyValue;
	}

	public Double getCurrencyValue() {
		return currencyValue;
	}

	@Override
	public String toString() {
		return "CurrencyValue{" +
				"currencyValue=" + currencyValue +
				'}';
	}
}
