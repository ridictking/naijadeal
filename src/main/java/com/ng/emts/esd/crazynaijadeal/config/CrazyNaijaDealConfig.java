package com.ng.emts.esd.crazynaijadeal.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CrazyNaijaDealConfig {
    @Bean
    public RestTemplate blackFridayRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
