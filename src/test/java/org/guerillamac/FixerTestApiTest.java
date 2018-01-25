package org.guerillamac;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.guerillamac.clients.eurclient.ValueFinder;
import org.guerillamac.entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Currency;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FixerTestApiTest {
	@InjectLogger
	private Logger logger;

	private FixerCurrencyService valueFinder = new FixerCurrencyService();
	

	@Test
	public void should_get_not_null_currency_table() throws Exception {

		Optional<CurrencyTable> values = valueFinder.findValues();
		assertTrue(values.isPresent());

		CurrencyValue usd = values.get().getValueFor(Currency.getInstance("USD"));
		logger.info(usd.toString());
		Assert.assertNotNull(usd);
	}
}
