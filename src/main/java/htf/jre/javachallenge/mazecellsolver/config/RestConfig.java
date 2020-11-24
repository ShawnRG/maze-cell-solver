package htf.jre.javachallenge.mazecellsolver.config;

import htf.jre.javachallenge.mazecellsolver.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Configuration
@Slf4j
public class RestConfig implements UriBuilderFactory {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                .build())
                .filter(logRequest())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    // This method returns filter function which will log request data
    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            //log.info("Request: {} {}", clientRequest.method());
            return Mono.just(clientRequest);
        });
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
