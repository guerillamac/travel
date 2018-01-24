package org.guerillamac.entities;

import java.util.Currency;

public interface CurrencyTable {
	CurrencyValue getValueFor(Currency currency);
}
