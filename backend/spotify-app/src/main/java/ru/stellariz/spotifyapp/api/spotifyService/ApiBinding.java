package ru.stellariz.spotifyapp.api.spotifyService;

import org.springframework.web.client.RestTemplate;

public abstract class ApiBinding {

    protected RestTemplate restTemplate;

    public ApiBinding(String accessToken){
        this.restTemplate = new RestTemplate();
        if (accessToken != null) {
            this.restTemplate.getInterceptors()
                    .add((request, body, execution)-> {
                        request.getHeaders().add("Authorization", "Bearer " + accessToken);
                        return execution.execute(request, body);
                    });
        } else {
            this.restTemplate.getInterceptors().add((request, body, execution)-> {
                throw new IllegalStateException(
                        "Can't access the API without an access token");
            });
        }
    }

}
