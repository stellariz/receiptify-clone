package ru.stellariz.spotifyapp.api.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SpotifyUser, String> {
}
