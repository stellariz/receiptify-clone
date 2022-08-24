package ru.stellariz.spotifyapp.api.spotifyService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.stellariz.spotifyapp.api.DTO.ArtistsList;
import ru.stellariz.spotifyapp.api.DTO.TrackList;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotifyService {

    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    private static final String BASE_URL = "https://api.spotify.com/v1";

    private static final String TRACKS = "/me/top/tracks";

    private static final String ARTISTS = "/me/top/artists";

    private static final int TRACKS_NUMBER = 10;

    public ResponseEntity<?> getTracks(String registrationId, String name, String time, String type) {
        URI uri;
        if (type.equals("tracks")) {
            uri = UriComponentsBuilder.fromUriString(BASE_URL + TRACKS)
                    .queryParam("limit", TRACKS_NUMBER)
                    .queryParam("time_range", time)
                    .build().toUri();
        } else {
            uri = UriComponentsBuilder.fromUriString(BASE_URL + ARTISTS)
                    .queryParam("limit", TRACKS_NUMBER)
                    .queryParam("time_range", time)
                    .build().toUri();
        }

        String accessToken = oAuth2AuthorizedClientService.loadAuthorizedClient(registrationId, name).getAccessToken().getTokenValue();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution)-> {
            request.getHeaders().add("Authorization", "Bearer " + accessToken);
            return execution.execute(request, body);
        });

        String jsonResponse = restTemplate.getForObject(uri, String.class);
        try {
            if (type.equals("tracks")) {
                TrackList trackList = new ObjectMapper().readValue(jsonResponse, TrackList.class);
                return ResponseEntity.ok(trackList);
            } else if (type.equals("artists")){
                ArtistsList artistsList = new ObjectMapper().readValue(jsonResponse, ArtistsList.class);
                return ResponseEntity.ok(artistsList);
            }
        } catch (JsonProcessingException e){
            log.error(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}
