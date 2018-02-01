package org.guerillamac;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.guerillamac.entities.CurrencyApiUri;
import org.guerillamac.entities.CurrencyTable;
import org.guerillamac.entities.FixerCurrencyService;
import org.guerillamac.services.CurrencyClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import java.net.URI;
import java.util.Optional;

import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockedFixerTestApiTest {
	@Mock
	CurrencyApiUri currencyApiUri;

	@Mock
	CurrencyClient client;

	@Mock
	Logger logger;

	@InjectMocks
	private FixerCurrencyService valueFinder;

	@Before
	public void setUp() throws Exception {
		valueFinder = new FixerCurrencyService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void should_return_empty_value_if_cant_parse() throws Exception {
		when(currencyApiUri.getUriOfCurrencyApi()).thenReturn(new URI("STUB"));
		when(client.executeGet(any(CurrencyApiUri.class))).thenReturn("STUB");
		Optional<CurrencyTable> values = valueFinder.findValues();

		Assert.assertFalse(values.isPresent());
	}

}
