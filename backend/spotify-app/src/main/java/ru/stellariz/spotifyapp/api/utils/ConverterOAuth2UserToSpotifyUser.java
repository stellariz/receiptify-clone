package ru.stellariz.spotifyapp.api.utils;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.stellariz.spotifyapp.api.db.SpotifyUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConverterOAuth2UserToSpotifyUser {
    public static SpotifyUser convertToSpotifyUser(OAuth2User oAuth2User){
        Map<String, Object> attrs = oAuth2User.getAttributes();

        final String spotifyId = attrs.get("id").toString();

        final String display_name = attrs.get("display_name").toString();

        final String email = attrs.get("email").toString();

        final String profileUrl = attrs.get("href").toString();

        var images = ((ArrayList< HashMap<String, String>>)attrs.get("images"));
        final String profilePictureUrl = images.size() == 0 ? null : images.get(0).get("url");

        return new SpotifyUser(spotifyId, email, display_name, profileUrl, profilePictureUrl);
    }
}
