package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class Person {
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    @JsonProperty("birth_date")
    private String birthDate;
    private List<Character> characters;
    private List<Concept> concepts;
    private String country;
    @JsonProperty("death_date")
    private String deathDate;
    private String deck;
    private String description;
    @JsonProperty("first_credited_game")
    private String firstCreditedGame;
    private List<Franchise> franchises;
    private List<Game> games;
    private String gender;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("image_tags")
    private String imageTags;
    private List<Location> locations;
    private String name;
    private List<Object> objects;
    private List<Person> people;
}
