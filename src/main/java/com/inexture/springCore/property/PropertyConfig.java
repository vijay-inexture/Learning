package com.inexture.springCore.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class PropertyConfig {

	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public PropertyDemo propertyDemo() {
		PropertyDemo pd = new PropertyDemo();
		pd.setUrl(url);
		pd.setUsername(username);
		pd.setPassword(password);
		return pd;
	}
	
}
