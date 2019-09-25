package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class Character {
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String birthday;
    private List<Concept> concepts;
    private String deck;
    private String description;
    private List<Character> enemies;
    @JsonProperty("first_appeared_in_game")
    private String firstAppearedInGame;
    private List<Franchise> franchises;
    private String friends;
    private List<Game> games;
    private String genders;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("image_tags")
    private String imageTags;
    @JsonProperty("last_name")
    private String lastName;
    private List<Location> locations;
    private String name;
    private List<Object> objects;
    private List<Person> people;
    @JsonProperty("real_name")
    private String realName;
}
