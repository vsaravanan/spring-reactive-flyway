package com.saravan.reactive.student;

/**
 * @author Sarav on 16 Apr 2024
 * @project govtech
 * @package com.govtech.demo.console
 * @class WebClientExample
 */

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientExample {

    public static void main(String[] args) {
        // Create a WebClient instance
        WebClient webClient = WebClient.create("https://api.example.com");

        // Make an HTTP GET request and retrieve the response body as a Mono<String>
        Mono<String> responseBodyMono = webClient.get()
                .uri("/resource")
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to the Mono and print the response body when it's available
        responseBodyMono.subscribe(responseBody -> {
            System.out.println("Response Body:");
            System.out.println(responseBody);
        });
    }
}


