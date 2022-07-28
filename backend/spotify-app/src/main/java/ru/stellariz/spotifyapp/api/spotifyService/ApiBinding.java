package ru.stellariz.spotifyapp.api.spotifyService;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public abstract class ApiBinding {

    protected RestTemplate restTemplate;

    public ApiBinding(String accessToken){
        restTemplate = new RestTemplate();
        if (accessToken != null){
            restTemplate.getInterceptors().add(getBearerTokenInterceptor(accessToken));
        } else {
            restTemplate.getInterceptors().add(getNoTokenInterceptor());
        }
    }

    private ClientHttpRequestInterceptor getBearerTokenInterceptor(String accessToken) {
        return (request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + accessToken);
            return execution.execute(request, body);
        };
    }

    private ClientHttpRequestInterceptor getNoTokenInterceptor() {
        return ((request, body, execution) -> {
            throw new IllegalStateException("Can't access API without an access token");
        });
    }
}