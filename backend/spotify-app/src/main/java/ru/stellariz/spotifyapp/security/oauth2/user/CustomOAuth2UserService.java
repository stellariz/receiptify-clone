package ru.stellariz.spotifyapp.security.oauth2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.stellariz.spotifyapp.api.db.SpotifyUser;
import ru.stellariz.spotifyapp.api.db.UserRepository;
import ru.stellariz.spotifyapp.exceptions.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        try {
            return processOAuth2User(oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = new OAuth2UserInfo(oAuth2User.getAttributes());

        Optional<SpotifyUser> spotifyUserOptional = userRepository.findById(oAuth2UserInfo.getId());
        SpotifyUser spotifyUser;
        if (spotifyUserOptional.isPresent()) {
            spotifyUser = spotifyUserOptional.get();
            spotifyUser = updateExistingUser(spotifyUser, oAuth2UserInfo);
        } else {
            spotifyUser = registerNewUser(oAuth2UserInfo);
        }
        return UserPrincipal.create(spotifyUser, oAuth2User.getAttributes());
    }

    private SpotifyUser registerNewUser(OAuth2UserInfo oAuth2UserInfo) {
        SpotifyUser user = new SpotifyUser();

        user.setSpotifyUserId(oAuth2UserInfo.getId());
        user.setDisplayName(oAuth2UserInfo.getName());
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setProfileUri(oAuth2UserInfo.getProfileUri());
        user.setProfilePictureUrl(oAuth2UserInfo.getImage());
        return userRepository.save(user);
    }

    private SpotifyUser updateExistingUser(SpotifyUser existingUser, OAuth2UserInfo OAuth2UserInfo) {
        existingUser.setDisplayName(OAuth2UserInfo.getName());
        existingUser.setProfilePictureUrl(OAuth2UserInfo.getImage());
        return userRepository.save(existingUser);
    }


    @Transactional
    public UserPrincipal loadUserById(String id) {
        SpotifyUser user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return UserPrincipal.create(user);
    }
}
