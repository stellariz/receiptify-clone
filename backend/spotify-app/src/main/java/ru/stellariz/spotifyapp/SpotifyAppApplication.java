package ru.stellariz.spotifyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpotifyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyAppApplication.class, args);
    }

}
