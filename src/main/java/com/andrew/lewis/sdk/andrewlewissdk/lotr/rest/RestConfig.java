package com.andrew.lewis.sdk.andrewlewissdk.lotr.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean("authRestTemplate")
    public RestTemplate restTemplate(
            @Value("${lotr.api.auth.token}") final String token
    ) {
        return new RestTemplateBuilder().rootUri("some uri")
                .additionalInterceptors((request, body, execution) -> {
                    request.getHeaders().add("Authorization", "Bearer " + token);
                    return execution.execute(request, body);
                }).build();
    }

}
