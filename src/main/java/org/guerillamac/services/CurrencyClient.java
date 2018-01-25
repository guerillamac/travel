package org.guerillamac.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.guerillamac.InjectLogger;
import org.guerillamac.entities.CurrencyApiUri;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class CurrencyClient {

	@InjectLogger
	Logger logger;

	private HttpClient client = HttpClients.createDefault();

	public String executeGet(CurrencyApiUri uri) {
		String json = "";
		try {
			HttpResponse response = execute(new HttpGet(uri.getUriOfCurrencyApi()));
			json = EntityUtils.toString(response.getEntity());
		} catch (IOException | URISyntaxException e) {
			logger.error("Could not perform request to uri: " + uri.toString(), e);
		}
		return json;
	}

	private HttpResponse execute(HttpUriRequest request) throws IOException {
		return client.execute(request);
	}
}
