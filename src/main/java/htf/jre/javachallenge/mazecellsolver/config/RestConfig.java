package htf.jre.javachallenge.mazecellsolver.config;

import htf.jre.javachallenge.mazecellsolver.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;


import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Configuration
public class RestConfig implements UriBuilderFactory {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                .build())
                .baseUrl(Constants.BASE_URL)
                .build();
    }


    @Override
    public UriBuilder uriString(String uriTemplate) {
        return null;
    }

    @Override
    public UriBuilder builder() {
        return null;
    }

    @Override
    public URI expand(String uriTemplate, Map<String, ?> uriVariables) {
        return null;
    }

    @Override
    public URI expand(String uriTemplate, Object... uriVariables) {
        return null;
    }
}
