package org.guerillamac;

import org.guerillamac.clients.eurclient.ValueFinder;
import org.guerillamac.entities.CurrencyApiUri;
import org.guerillamac.entities.FixerCurrencyService;
import org.guerillamac.services.EcbCurrencyApiUri;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestBeanConfig {

//	@Bean
//	public CurrencyApiUri getCurrencyApiUri(){
//		return new EcbCurrencyApiUri();
//	}
//
//	@Bean
//	public BeanPostProcessor getLogger(){
//		return new LogInjector();
//	}


}
