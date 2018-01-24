package org.guerillamac;

import org.guerillamac.services.parsing.XmlParseUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlParseUtilityTest {

	@Test
	public void should_cut_xml_to_value_nodes() throws Exception {
		String ROOT_STARTING_ELEMENT = "<Cube currency";
		String ROOT_ENDING_ELEMENT = "</Cube>";
		String XML = "<gesmes:Envelope><gesmes:subject>Reference rates</gesmes:subject><gesmes:Sender></gesmes:Sender><Cube><Cube time=\"2017-12-15\"><Cube currency=\"USD\" rate=\"1.1806\"/><Cube currency=\"JPY\" rate=\"132.45\"/><Cube currency=\"BGN\" rate=\"1.9558\"/><Cube currency=\"CZK\" rate=\"25.678\"/><Cube currency=\"DKK\" rate=\"7.4443\"/><Cube currency=\"GBP\" rate=\"0.88253\"/><Cube currency=\"HUF\" rate=\"313.43\"/><Cube currency=\"PLN\" rate=\"4.2167\"/><Cube currency=\"RON\" rate=\"4.6332\"/><Cube currency=\"SEK\" rate=\"9.9583\"/><Cube currency=\"CHF\" rate=\"1.1669\"/><Cube currency=\"NOK\" rate=\"9.7828\"/><Cube currency=\"HRK\" rate=\"7.5465\"/><Cube currency=\"RUB\" rate=\"69.5043\"/><Cube currency=\"TRY\" rate=\"4.5603\"/><Cube currency=\"AUD\" rate=\"1.5382\"/><Cube currency=\"BRL\" rate=\"3.9171\"/><Cube currency=\"CAD\" rate=\"1.5070\"/><Cube currency=\"CNY\" rate=\"7.8022\"/><Cube currency=\"HKD\" rate=\"9.2223\"/><Cube currency=\"IDR\" rate=\"16029.01\"/><Cube currency=\"ILS\" rate=\"4.1634\"/><Cube currency=\"INR\" rate=\"75.6085\"/><Cube currency=\"KRW\" rate=\"1284.73\"/><Cube currency=\"MXN\" rate=\"22.6281\"/><Cube currency=\"MYR\" rate=\"4.8163\"/><Cube currency=\"NZD\" rate=\"1.6803\"/><Cube currency=\"PHP\" rate=\"59.528\"/><Cube currency=\"SGD\" rate=\"1.5897\"/><Cube currency=\"THB\" rate=\"38.375\"/><Cube currency=\"ZAR\" rate=\"15.7809\"/></Cube></Cube></gesmes:Envelope>";
		String expected = "<Cube currency=\"USD\" rate=\"1.1806\"/><Cube currency=\"JPY\" rate=\"132.45\"/><Cube currency=\"BGN\" rate=\"1.9558\"/><Cube currency=\"CZK\" rate=\"25.678\"/><Cube currency=\"DKK\" rate=\"7.4443\"/><Cube currency=\"GBP\" rate=\"0.88253\"/><Cube currency=\"HUF\" rate=\"313.43\"/><Cube currency=\"PLN\" rate=\"4.2167\"/><Cube currency=\"RON\" rate=\"4.6332\"/><Cube currency=\"SEK\" rate=\"9.9583\"/><Cube currency=\"CHF\" rate=\"1.1669\"/><Cube currency=\"NOK\" rate=\"9.7828\"/><Cube currency=\"HRK\" rate=\"7.5465\"/><Cube currency=\"RUB\" rate=\"69.5043\"/><Cube currency=\"TRY\" rate=\"4.5603\"/><Cube currency=\"AUD\" rate=\"1.5382\"/><Cube currency=\"BRL\" rate=\"3.9171\"/><Cube currency=\"CAD\" rate=\"1.5070\"/><Cube currency=\"CNY\" rate=\"7.8022\"/><Cube currency=\"HKD\" rate=\"9.2223\"/><Cube currency=\"IDR\" rate=\"16029.01\"/><Cube currency=\"ILS\" rate=\"4.1634\"/><Cube currency=\"INR\" rate=\"75.6085\"/><Cube currency=\"KRW\" rate=\"1284.73\"/><Cube currency=\"MXN\" rate=\"22.6281\"/><Cube currency=\"MYR\" rate=\"4.8163\"/><Cube currency=\"NZD\" rate=\"1.6803\"/><Cube currency=\"PHP\" rate=\"59.528\"/><Cube currency=\"SGD\" rate=\"1.5897\"/><Cube currency=\"THB\" rate=\"38.375\"/><Cube currency=\"ZAR\" rate=\"15.7809\"/>";
		String result = XmlParseUtility.concutXmlToOnlyInterestedNodes(XML, ROOT_STARTING_ELEMENT, ROOT_ENDING_ELEMENT);
		Assert.assertEquals(expected, result);
	}
}
