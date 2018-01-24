package org.guerillamac.services;

import java.util.Optional;

public interface CurrencyParser<T> {
	Optional<T> parse(String xmlToParse);
}
