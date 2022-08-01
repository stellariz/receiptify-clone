package ru.stellariz.spotifyapp.security.oauth2.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
public class OAuth2UserInfo {
    private final Map<String, Object> attributes;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getId(){
        return (String)attributes.get("id");
    }

    public String getEmail(){
        return (String)attributes.get("email");
    }

    public String getName(){
        return (String)attributes.get("display_name");
    }

    public String getProfileUri(){
        return (String)attributes.get("uri");
    }

    public String getImage(){
        try {
            return objectMapper.writeValueAsString(attributes.get("images"));
        } catch (JsonProcessingException e){
            log.error("Can't convert image to string: {}", e.getMessage());
            return "";
        }
    }
}
