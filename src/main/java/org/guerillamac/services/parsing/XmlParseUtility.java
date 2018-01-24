package org.guerillamac.services.parsing;

import org.springframework.stereotype.Component;

@Component
public class XmlParseUtility {

	public static String concutXmlToOnlyInterestedNodes(String endpointResponseAsXml, String rootStartingElement, String rootEndingElement){
		int rootElementStartingIndex = endpointResponseAsXml.indexOf(rootStartingElement);
		int rootElementEndingIndex = endpointResponseAsXml.indexOf(rootEndingElement);
		return endpointResponseAsXml.substring(rootElementStartingIndex, rootElementEndingIndex);
	}
}
