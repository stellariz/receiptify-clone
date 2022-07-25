package ru.stellariz.spotifyapp.api.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
    private final UserRepository userRepository;

    public SpotifyUser addUser(Long spotifyId, String displayName) {
        Optional<SpotifyUser> spotifyUser = userRepository.findById(spotifyId);
        return spotifyUser.orElse(userRepository.save(new SpotifyUser(spotifyId, displayName)));
    }
}
