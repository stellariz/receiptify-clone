package ru.stellariz.spotifyapp.api;

public enum TIME_RANGE {
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
