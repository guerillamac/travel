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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Currency;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {TestBeanConfig.class})
//@Import(TestBeanConfig.class)
public class FixerTestApiTest {

	private final static String URI_FIXER = "https://api.fixer.io/latest";
	private String json;

	@Autowired
	private ValueFinder valueFinder;

	@Before
	public void setUp() throws Exception {
		getRequestFromUri();

	}

	@Test
	public void should_get_json_as_string() throws Exception {

		boolean empty = json.trim().isEmpty();
		Assert.assertFalse(empty);
	}


	public void should_get_not_null_object() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.readValue(json, ObjectNode.class);
		Currency referenceCurrency = null;
		CurrencyCode keyForFindingReferenceCurrency = new CurrencyCode("base");
		if(objectNode.has("base")) {
			JsonNode jsonNode = objectNode.get(keyForFindingReferenceCurrency.getCurrencyCode());
			referenceCurrency = Currency.getInstance(jsonNode.asText());
		}
//		Assert.assertNotNull(referenceCurrency);
		String keyForBindingCurrencyValues = "rates";
		if (objectNode.has(keyForBindingCurrencyValues)) {
			Iterator<Map.Entry<String, JsonNode>> currencyNodes = objectNode.get(keyForBindingCurrencyValues).fields();
			while(currencyNodes.hasNext()){
				Map.Entry<String, JsonNode> currencyPair = currencyNodes.next();
				Currency.getInstance(currencyPair.getKey());
				currencyPair.getValue().asDouble();

			}


		}
	}

	@Test
	public void should_get_not_null_currency_table() throws Exception {

		CurrencyTable values = valueFinder.findValues();

		CurrencyValue usd = values.getValueFor(Currency.getInstance("USD"));
		Assert.assertNotNull(usd);
	}

	private void getRequestFromUri() throws IOException {
		HttpClient client = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(URI_FIXER);
		HttpResponse response = client.execute(getRequest);
		json = EntityUtils.toString(response.getEntity());
	}
}
