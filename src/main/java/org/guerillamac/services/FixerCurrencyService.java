package org.guerillamac.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.guerillamac.InjectLogger;
import org.guerillamac.clients.eurclient.ValueFinder;
import org.guerillamac.entities.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class FixerCurrencyService implements ValueFinder {

	@Autowired
	private CurrencyApiUri uri;

	@Autowired
	private CurrencyClient currencyClient;

	@InjectLogger @SuppressWarnings("unused")
	private Logger logger;

	@Override
	public Optional<CurrencyTable> findValues() {
		return tryToExecute();
	}

	private Optional<CurrencyTable> tryToExecute() {
		try {
			String response = currencyClient.executeGet(uri);
			return parseJson(response);
		} catch (IOException e) {
			logger.error("ERROR occurred during working with FIXER API");
			throw new RuntimeException();
		}
	}

	private Optional<CurrencyTable> parseJson(String response) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode node = objectMapper.readValue(response, ObjectNode.class);
		logger.info("started parsing of Json");
		return extractCurrencyTableFromJson(node);
	}

	private Optional<CurrencyTable> extractCurrencyTableFromJson(ObjectNode node) {
		CurrencyCode keyForFindingReferenceCurrency = new CurrencyCode("base");
		Currency referenceCurrency;
		String keyForBindingCurrencyValues = "rates";

		if (isSuitableToParse(node, keyForBindingCurrencyValues)) {
			JsonNode jsonNode = node.get(keyForFindingReferenceCurrency.getCurrencyCode());
			referenceCurrency = Currency.getInstance(jsonNode.asText());
			Map<Currency, CurrencyValue> input = populateCurrencyTable(node, keyForBindingCurrencyValues);

			return Optional.of(new FixerCurrencyTable(input, referenceCurrency));
		}
		return Optional.empty();
	}

	private Map<Currency, CurrencyValue> populateCurrencyTable(ObjectNode node, String keyForBindingCurrencyValues) {
		Map<Currency, CurrencyValue> input = new HashMap<>();
		Iterator<Map.Entry<String, JsonNode>> currencyNodes = node.get(keyForBindingCurrencyValues).fields();
		while (currencyNodes.hasNext()) {
			Map.Entry<String, JsonNode> currencyPair = currencyNodes.next();
			Currency currency = Currency.getInstance(currencyPair.getKey());
			CurrencyValue value = new CurrencyValue(currencyPair.getValue().asDouble());
			input.put(currency, value);
		}
		return input;
	}

	private boolean isSuitableToParse(ObjectNode node, String keyForBindingCurrencyValues) {
		return node.has("base") && node.has(keyForBindingCurrencyValues);
	}

}
