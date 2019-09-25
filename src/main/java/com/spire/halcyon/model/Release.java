package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class Release {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String deck;
    private String description;
    private List<Developer> developers;
    @JsonProperty("expected_release_day")
    private String expectedReleaseDay;
    @JsonProperty("expected_release_month")
    private String expectedReleaseMonth;
    @JsonProperty("expected_release_year")
    private String expectedReleaseYear;
    private Game game;
    @JsonProperty("game_rating")
    private String gameRating;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("maximum_players")
    private String maximumPlayers;
    @JsonProperty("minimum_players")
    private String minimumPlayers;
    @JsonProperty("multiplayer_features")
    private String multiplayerFeatures;
    private String name;
    private List<Platform> platforms;
    @JsonProperty("product_code_type")
    private String productCodeType;
    @JsonProperty("product_code_value")
    private String productCodeValue;
    private List<Publisher> publishers;
    private String region;
    @JsonProperty("release_date")
    private String releaseDate;
    private String resolutions;
    @JsonProperty("singleplayer_features")
    private String singlePlayerFeatures;
    @JsonProperty("sound_systems")
    private String soundSystems;
    @JsonProperty("widescreen_support")
    private String widescreenSupport;

}
