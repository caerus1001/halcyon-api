package com.spire.halcyon.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated"})
public class Game {
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private List<Character> characters;
    private List<Concept> concepts;
    private String deck;
    private String description;
    private List<Developer> developers;
    @JsonProperty("expected_release_day")
    private String expectedReleaseDay;
    @JsonProperty("expected_release_month")
    private String expectedReleaseMonth;
    @JsonProperty("expected_release_quarter")
    private String expectedReleaseQuarter;
    @JsonProperty("expected_release_year")
    private String expectedReleaseYear;
    @JsonProperty("first_appearance_characters")
    private List<Character> firstAppearanceCharacters;
    @JsonProperty("first_appearance_concepts")
    private List<Concept> firstAppearanceConcepts;
    @JsonProperty("first_appearance_locations")
    private List<Location> firstAppearanceLocations;
    @JsonProperty("first_appearance_objects")
    private List<Object> firstAppearanceObjects;
    @JsonProperty("first_appearance_people")
    private List<Person> firstAppearancePeople;
    private List<Franchise> franchises;
    private List<Genre> genres;
    private String guid;
    @Id
    private String id;
    private Image image;
    private List<Image> images;
    @JsonProperty("image_tags")
    private List<ImageTag> imageTags;
    @JsonProperty("killed_characters")
    private String killedCharacters;
    private List<Location> locations;
    private String name;
    @JsonProperty("number_of_user_reviews")
    private String numberOfUserReviews;
    private List<Object> objects;
    @JsonProperty("original_game_rating")
    private List<GameRating> originalGameRating;
    @JsonProperty("original_release_date")
    private String originalReleaseDate;
    private List<Person> people;
    private List<Platform> platforms;
    private List<Publisher> publishers;
    private List<Release> releases;
    private List<DLC> dlcs;
    private List<Review> reviews;
    @JsonProperty("similar_games")
    private List<Game> similarGames;
    @JsonProperty("site_detail_url")
    private String siteDetailUrl;
    private List<Theme> themes;
    private List<Video> videos;

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " platforms: " + platforms.toString() + " genres: " + genres.toString() + " publishers: " + publishers.toString()
                + " expected release date: " + expectedReleaseYear + "-" + expectedReleaseMonth + "-" + expectedReleaseDay;
    }
}
