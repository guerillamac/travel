package org.guerillamac;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.guerillamac.entities.CurrencyApiUri;
import org.guerillamac.entities.EcbCurrencyTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@SpringBootTest
public class CurrencyEndpointTest {

	@InjectLogger
	Logger logger;

	@Autowired
	CurrencyApiUri currencyApiUri;
	@Test
	public void shouldChangeValue() {
		logger.info("++++++++++++++++++++++++");

		HttpGet request = new HttpGet(currencyApiUri.getUriOfCurrencyApi());
		HttpClient client = HttpClients.createDefault();
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			String responseBody = EntityUtils.toString(entity, UTF_8);
			logger.info(responseBody);
			XmlMapper mapper = new XmlMapper();
//			SimpleModule module = new SimpleModule();
//			module.addSerializer();
//			mapper.registerModule();

			EcbCurrencyTable ecbCurrencyTable = mapper.readValue(responseBody, EcbCurrencyTable.class);

		} catch (IOException e) {
			logger.error("Error during sending request", e);
		}
	}
}

