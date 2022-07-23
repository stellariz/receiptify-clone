package ru.stellariz.spotifyapp.api;

import ru.stellariz.spotifyapp.Core.Track;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotifyService extends ApiBinding {
    private static final String BASE_URL = "https://api.spotify.com/v1";

    private static final String TRACKS = "/me/top/tracks";

    private static final String ARTISTS = "/me/top/artists";

    private static final int TRACKS_NUMBER = 10;

    public SpotifyService(String accessToken) {
        super(accessToken);
    }

    public List<Track> getTop10TracksForAllTime() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("limit", String.valueOf(10));
        queryParams.put("time_range", TIME_RANGE.ALL_TIME.getTimeRange());
        var tmp = restTemplate.getForObject(BASE_URL + TRACKS, Object.class, queryParams);
        return null;
    }
}
