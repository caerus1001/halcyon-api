package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "concepts"})
public class Company {
    private String abbreviation;
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private List<Character> characters;
    //private List<Concepts> concepts;
    @JsonProperty("date_founded")
    private String dateFounded;
    private String deck;
    private String description;
    @JsonProperty("developed_games")
    private String developedGames;
    @JsonProperty("developer_releases")
    private String developerReleases;
    @JsonProperty("distributor_releases")
    private String distributorReleases;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("image_tags")
    private String imageTags;
    @JsonProperty("location_address")
    private String locationAddress;
    @JsonProperty("location_city")
    private String locationCity;
    @JsonProperty("location_country")
    private String locationCountry;
    @JsonProperty("location_state")
    private String locationState;
    private List<Location> locations;
    private String name;
    private List<Object> objects;
    private List<Person> people;
    private String phone;
    @JsonProperty("published_games")
    private String publishedGames;
    @JsonProperty("publisher_releases")
    private String publisherReleases;
    @JsonProperty("site_detail_url")
    private String siteDetailUrl;
    private String website;
}
