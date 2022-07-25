package ru.stellariz.spotifyapp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<OAuth2User> getInfo(@AuthenticationPrincipal OAuth2User principal){
        return ResponseEntity.ok(principal);
    }
}
