package ru.stellariz.spotifyapp.api;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

// rewrite with hierarchy
public class SpotifyService extends ApiBinding {
    private static final String BASE_URL = "https://api.spotify.com/v1";

    private static final String TRACKS = "/me/top/tracks";

    private static final String ARTISTS = "/me/top/artists";

    private static final int TRACKS_NUMBER = 10;

    enum TIME_RANGE {
        ALL_TIME("long_term"),
        SIX_MONTHS("medium_term"),
        ONE_MONTH("short_term");

        private final String timeRange;

        TIME_RANGE(String timeRange) {
            this.timeRange = timeRange;
        }

        public String getTimeRange() {
            return timeRange;
        }
    }

    public SpotifyService(String accessToken) {
        super(accessToken);
    }

    public ResponseEntity<?> getTop10TracksForAllTime() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("limit", String.valueOf(TRACKS_NUMBER));
        queryParams.put("time_range", TIME_RANGE.ALL_TIME.getTimeRange());
        return ResponseEntity.ok(restTemplate.getForEntity(BASE_URL + TRACKS, Object.class, queryParams));
    }

    public ResponseEntity<?> getTop10TracksFor6Month() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("limit", String.valueOf(TRACKS_NUMBER));
        queryParams.put("time_range", TIME_RANGE.SIX_MONTHS.getTimeRange());
        return ResponseEntity.ok(restTemplate.getForEntity(BASE_URL + TRACKS, Object.class, queryParams));
    }

    public ResponseEntity<?> getTop10TracksForMonth() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("limit", String.valueOf(TRACKS_NUMBER));
        queryParams.put("time_range", TIME_RANGE.ONE_MONTH.getTimeRange());
        return ResponseEntity.ok(restTemplate.getForEntity(BASE_URL + TRACKS, Object.class, queryParams));
    }
}
