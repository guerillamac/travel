package org.guerillamac;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.guerillamac.entities.CurrencyApiUri;
import org.guerillamac.entities.CurrencyTable;
import org.guerillamac.entities.FixerCurrencyService;
import org.guerillamac.services.CurrencyClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URI;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockedFixerTestApiTest {
	@Mock
	CurrencyApiUri currencyApiUri;

	@Mock
	ObjectMapper mapper;

	@Mock
	CurrencyClient client;

	@InjectMocks
	private FixerCurrencyService valueFinder;

	@Before
	public void setUp() throws Exception {
		valueFinder = new FixerCurrencyService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void should_return_empty_value_if_cant_parse() throws Exception {
		Optional<CurrencyTable> values = valueFinder.findValues();
//		when(currencyApiUri.getUriOfCurrencyApi()).then(any(URI.class));

		Assert.assertFalse(values.isPresent());
	}

}
