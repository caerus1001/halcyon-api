package com.spire.halcyon.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties({"error", "limit", "offset", "number_of_page_results", "number_of_total_results", "status_code", "version"})
public class Game {
    @Id
    private String id;
    private String name;
    private List<Platform> platforms;
    private List<Genre> genres;
    private String releaseDate;
    @JsonProperty("expected_release_day")
    private String expectedReleaseDay;
    @JsonProperty("expected_release_month")
    private String expectedReleaseMonth;
    @JsonProperty("expected_release_year")
    private String expectedReleaseYear;
    private Image image;
    private List<Publisher> publishers;

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " platforms: " + platforms.toString() + " genres: " + genres.toString() + " publishers: " + publishers.toString()
                + " expected release date: " + expectedReleaseYear + "-" + expectedReleaseMonth + "-" + expectedReleaseDay;
    }
}
