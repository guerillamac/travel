package org.guerillamac.services.parsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "entry")
@JsonIgnoreProperties(ignoreUnknown = true)
class EcbCurrencyRow {
	@JacksonXmlProperty(isAttribute = true, localName = "currency")
	private String currencyCode;
	@JacksonXmlProperty(isAttribute = true)
	private String rate;
}
