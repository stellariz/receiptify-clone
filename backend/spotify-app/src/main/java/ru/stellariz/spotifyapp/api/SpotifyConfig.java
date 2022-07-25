package ru.stellariz.spotifyapp.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpotifyConfig {

    @Bean
    @RequestScope
    public SpotifyService spotifyService(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oathToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oathToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals("spotify")) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oathToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        System.out.println(accessToken);
        return new SpotifyService(accessToken);
    }
}
