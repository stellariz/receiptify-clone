package ru.stellariz.spotifyapp.security.oauth2.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.stellariz.spotifyapp.api.db.SpotifyUser;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class UserPrincipal implements OAuth2User {
    private final String id;
    private final String name;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(String id, String name, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.authorities = authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return name;
    }

    public static UserPrincipal create(SpotifyUser user) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getSpotifyUserId(),
                user.getDisplayName(),
                user.getEmail(),
                authorities
        );
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static UserPrincipal create(SpotifyUser user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
