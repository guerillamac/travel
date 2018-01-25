package org.guerillamac;

import org.guerillamac.entities.CurrencyTable;
import org.guerillamac.entities.CurrencyValue;
import org.guerillamac.entities.FixerCurrencyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Currency;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FixerTestApiTest {

	@Autowired
	private FixerCurrencyService valueFinder;

	@Test
	public void should_get_not_null_currency_table() throws Exception {

		Optional<CurrencyTable> values = valueFinder.findValues();
		assertTrue(values.isPresent());

		CurrencyValue usd = values.get().getValueFor(Currency.getInstance("USD"));
		System.out.println(usd);
		Assert.assertNotNull(usd);
	}
}
