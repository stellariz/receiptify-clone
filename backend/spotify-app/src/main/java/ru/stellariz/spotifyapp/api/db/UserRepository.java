package ru.stellariz.spotifyapp.api.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SpotifyUser, String> {
    Optional<SpotifyUser> findSpotifyUserByDisplayName(String display_name);

    Optional<SpotifyUser> findSpotifyUserBySpotifyUserId(String spotifyUserId);
}
