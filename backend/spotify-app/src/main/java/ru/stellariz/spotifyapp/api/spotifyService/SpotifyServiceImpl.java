package ru.stellariz.spotifyapp.api.spotifyService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import ru.stellariz.spotifyapp.api.DTO.ArtistsList;
import ru.stellariz.spotifyapp.api.DTO.TrackList;

import java.net.URI;

@Slf4j
public class SpotifyServiceImpl extends ApiBinding implements SpotifyService {

    private static final String BASE_URL = "https://api.spotify.com/v1";

    private static final String TRACKS = "/me/top/tracks";

    private static final String ARTISTS = "/me/top/artists";

    private static final int TRACKS_NUMBER = 10;

    private final URI TrackURI;
    private final URI ArtistsURI;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpotifyServiceImpl(String accessToken) {
        super(accessToken);
        TrackURI = UriComponentsBuilder.fromUriString(BASE_URL + TRACKS)
                .queryParam("limit", TRACKS_NUMBER)
                .build().toUri();
        ArtistsURI = UriComponentsBuilder.fromUriString(BASE_URL + ARTISTS)
                .queryParam("limit", TRACKS_NUMBER)
                .build().toUri();
    }

    @Override
    public TrackList getTracks(String time) {
        URI uri = UriComponentsBuilder.fromUri(TrackURI)
                .queryParam("time_range", time)
                .build().toUri();

        String jsonResponse = restTemplate.getForObject(uri, String.class);
        TrackList trackList;
        try {
            trackList = objectMapper.readValue(jsonResponse, TrackList.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return trackList;
    }

    @Override
    public ArtistsList getArtists(String time) {
        URI uri = UriComponentsBuilder.fromUri(ArtistsURI)
                .queryParam("time_range", time)
                .build().toUri();

        String jsonResponse = restTemplate.getForObject(uri, String.class);

        ArtistsList artistsList;
        try {
            artistsList = objectMapper.readValue(jsonResponse, ArtistsList.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return artistsList;
    }
}
