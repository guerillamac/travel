package org.guerillamac.services;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

@Component
public class CurrencyClient {
	private HttpClient client = HttpClients.createDefault();
	//TODO extract interface and add abstraction to HttpClient from apache
	public HttpClient getClient() {
		return client;
	}
}
