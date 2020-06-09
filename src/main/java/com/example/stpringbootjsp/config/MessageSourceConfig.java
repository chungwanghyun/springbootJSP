package com.example.stpringbootjsp.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MessageSourceConfig {

	/**
	 * Message Resources Bean
	 *
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("i18n/messages");
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		return messageSource;
	}

	/**
	 * Locale Resolver
	 *
	 */
	@Bean
	public LocaleResolver localeResolver() {
		 return new CookieLocaleResolver();
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.JAPAN);
//		return localeResolver;
	}

	/**
	 * Locale Change Interceptor
	 *
	 */
	@Bean
	public WebMvcConfigurer localeInterceptor() {
		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
				localeInterceptor.setParamName("lang");
				registry.addInterceptor(localeInterceptor);
			}
		};
	}



}
