package org.guerillamac;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class LogInjector implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException {

		ReflectionUtils.doWithFields(bean.getClass(), (field)-> {
					// make the field accessible if defined private
				ReflectionUtils.makeAccessible(field);
				if (field.getAnnotation(InjectLogger.class) != null) {
					Logger log = LoggerFactory.getLogger(bean.getClass());
					field.set(bean, log);
			}
		});
		return bean;
	}
}
