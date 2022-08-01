package ru.stellariz.spotifyapp.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stellariz.spotifyapp.api.db.UserRepository;
import ru.stellariz.spotifyapp.api.spotifyService.SpotifyService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final SpotifyService spotifyService;

    private final UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<?> getInfo(@AuthenticationPrincipal Authentication authentication) {
        // principal hasn't all credentials
        log.info(authentication.getName());
        return ResponseEntity.ok("hi");
    }

    @GetMapping("/get_tracks")
    public ResponseEntity<?> getTracks(@RequestParam String time, @RequestParam String type) {
        return spotifyService.getTracks(time, type);
    }
}
