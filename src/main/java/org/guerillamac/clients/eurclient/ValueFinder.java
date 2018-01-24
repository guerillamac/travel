package org.guerillamac.clients.eurclient;

import org.guerillamac.entities.CurrencyTable;

import java.util.Optional;

public interface ValueFinder {

	Optional<CurrencyTable> findValues();
}
