package ru.stellariz.spotifyapp.api.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
    private final UserRepository userRepository;

    public SpotifyUser addUser(OAuth2User oAuth2User) {
        final String spotifyId = oAuth2User.getAttribute("id").toString();
        Optional<SpotifyUser> spotifyUser = userRepository.findById(spotifyId);
        return spotifyUser.orElse(userRepository.save(ConverterOAuth2UserToSpotifyUser.convertToSpotifyUser(oAuth2User)));
    }

    public Optional<SpotifyUser> findUserBySpotifyId(String spotifyId) {
        return userRepository.findById(spotifyId);
    }
}
