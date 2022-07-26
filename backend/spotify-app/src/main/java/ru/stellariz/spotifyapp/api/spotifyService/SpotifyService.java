package ru.stellariz.spotifyapp.api.spotifyService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import ru.stellariz.spotifyapp.api.DTO.TrackList;

import java.net.URI;

@Slf4j
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
        String jsonResponse = restTemplate.getForObject(uri, String.class);
        TrackList trackList = null;
        try {
            trackList = new ObjectMapper().readValue(jsonResponse, TrackList.class);
        } catch (JsonProcessingException e){
            log.error(e.getMessage());
        }
        return ResponseEntity.ok(trackList);
    }
}
