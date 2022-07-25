package ru.stellariz.spotifyapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;


public class AppUser implements OAuth2User {

    private final OAuth2User oAuth2User;

    public AppUser(OAuth2User oAuth2User) {
        this.oAuth2User = oAuth2User;
    }

    @JsonIgnore
    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oAuth2User.getAuthorities();
    }


    @Override
    public String getName() {
        return oAuth2User.getName();
    }
}
