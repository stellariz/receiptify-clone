package ru.stellariz.spotifyapp.api.spotifyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class SpotifyService extends ApiBinding {
    private static final String BASE_URL = "https://api.spotify.com/v1";

    private static final String TRACKS = "/me/top/tracks";

    private static final String ARTISTS = "/me/top/artists";

    private static final int TRACKS_NUMBER = 10;


    public SpotifyService(String accessToken) {
        super(accessToken);
    }

    public ResponseEntity<?> getTracks(String time, String type) {
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
        return ResponseEntity.ok(restTemplate.getForEntity(uri, Object.class));
    }
}
