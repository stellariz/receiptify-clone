package ru.stellariz.spotifyapp.api.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    private String name;
    private String preview_url;
    private Album album;
    private List<Artist> artists;
    private String popularity;
}
