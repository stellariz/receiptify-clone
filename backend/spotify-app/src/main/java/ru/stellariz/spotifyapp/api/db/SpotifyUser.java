package ru.stellariz.spotifyapp.api.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyUser {
    @Id
    private String spotifyUserId;
    private String email;
    private String displayName;
    private String profileUri;
    private String profilePictureUrl;
    private OAuth2AccessToken oAuth2AccessToken;
}
