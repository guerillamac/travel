package org.guerillamac.services.parsing;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Cube")
public class EcbCurrencyTableRootElement {
	private EcbCurrencyRow row;
}
