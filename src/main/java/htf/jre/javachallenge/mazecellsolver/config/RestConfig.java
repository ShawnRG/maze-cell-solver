package htf.jre.javachallenge.mazecellsolver.config;

import htf.jre.javachallenge.mazecellsolver.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Configuration
public class RestConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .uriBuilderFactory(uriBuilder -> uriBuilder
                        .path("/products/")
                        .queryParam("name", "AndroidPhone")
                        .queryParam("color", "black")
                        .queryParam("deliveryDate", "13/04/2019")
                        .build();)
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    public UriBuilderFactory uriBuilderFactory() {
        return uriBuilder -> uriBuilder
                    .path("/products/")
                    .queryParam("name", "AndroidPhone")
                    .queryParam("color", "black")
                    .queryParam("deliveryDate", "13/04/2019")
                    .build();
        };
    }
}
