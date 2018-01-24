package org.guerillamac.entities;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.guerillamac.InjectLogger;
import org.guerillamac.services.CurrencyParser;
import org.guerillamac.services.parsing.EcbCurrencyTableRootElement;
import org.guerillamac.services.parsing.XmlParseUtility;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Currency;
import java.util.Optional;

@Component
public class EcbCurrencyTable {//implements CurrencyTable, CurrencyParser<EcbCurrencyTableRootElement> {
	private static final Currency referenceCurrency = Currency.getInstance("EUR");
//
//	@InjectLogger
//	private	Logger logger;
//
//	@Override
//	public Optional<Currency> getReferenceCurrency() {
//		return referenceCurrency;
//	}
//
//	@Override
//	public Double getValueFor(Currency currency) {
//		return null;
//	}
//
//	public Optional<EcbCurrencyTableRootElement> parse(String endpointResponseAsXml){
//		String ROOT_STARTING_ELEMENT = "<Cube currency";
//		String ROOT_ENDING_ELEMENT = "</Cube>";
//		String valueNodes = XmlParseUtility.concutXmlToOnlyInterestedNodes(endpointResponseAsXml, ROOT_STARTING_ELEMENT, ROOT_ENDING_ELEMENT);
//		XmlMapper mapper = new XmlMapper();
//
//		return tryToParseXmlToEcbValuesSet(valueNodes, mapper);
//	}
//
//	private Optional<EcbCurrencyTableRootElement> tryToParseXmlToEcbValuesSet(String valueNodes, XmlMapper mapper) {
//		Optional<EcbCurrencyTableRootElement> parsedEcbCurrency = Optional.empty();
//		try {
//			logger.info("parsing xml");
//			parsedEcbCurrency = Optional.of(mapper.readValue(valueNodes, EcbCurrencyTableRootElement.class));
//		} catch (IOException e) {
//			logger.error("failed to parse xml to object", e);
//		}
//		return parsedEcbCurrency;
//	}
//

}
