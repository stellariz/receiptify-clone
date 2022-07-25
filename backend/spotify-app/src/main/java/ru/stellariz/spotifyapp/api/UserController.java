package ru.stellariz.spotifyapp.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stellariz.spotifyapp.api.core.SpotifyUser;
import ru.stellariz.spotifyapp.api.core.UserRegisterService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final SpotifyService spotifyService;

    private final UserRegisterService userRegisterService;

    @GetMapping("/user")
    public ResponseEntity<SpotifyUser> getInfo(@AuthenticationPrincipal OAuth2User principal) {
        final String spotifyId = principal.getAttribute("id").toString();
        return ResponseEntity.ok(userRegisterService.findUserBySpotifyId(spotifyId).orElse(null));
    }

    @GetMapping("/get_tracks")
    public ResponseEntity<?> getTracks() {
        return spotifyService.getTop10TracksForAllTime();
    }
}
