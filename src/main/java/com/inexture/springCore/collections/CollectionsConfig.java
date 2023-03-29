package com.inexture.springCore.collections;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectionsConfig {
	
	@Bean
    public CollectionsBean collectionsBean() {
        return new CollectionsBean();
    }

    @Bean
    public List<String> nameList() {
        return Arrays.asList("John", "Adam", "Harry");
    }

}
