package ru.stellariz.spotifyapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.stellariz.spotifyapp.AppProperties;
import ru.stellariz.spotifyapp.security.oauth2.user.UserPrincipal;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenProvider {
    private final AppProperties appProperties;

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Algorithm algorithm = Algorithm.HMAC256(appProperties.getAuth().getTokenSecret().getBytes());
        return JWT.create()
                .withSubject(userPrincipal.getId())
                .withExpiresAt(Instant.now().plusMillis(appProperties.getAuth().getTokenExpirationMsec()))
                .sign(algorithm);
     }

     public String getUserIdFromToken(String token){
        return JWT.decode(token).getHeaderClaim("subject").asString();
     }

     public boolean validateToken(String token) {
        var claims =  JWT.decode(token).getClaims();
        log.info("Token's validating: {}", token);
        return claims != null;
     }
}
