package ru.stellariz.spotifyapp.api.spotifyService;

import ru.stellariz.spotifyapp.api.DTO.ArtistsList;
import ru.stellariz.spotifyapp.api.DTO.TrackList;

public interface SpotifyService {
    TrackList getTracks(String time);

    ArtistsList getArtists(String time);
}
