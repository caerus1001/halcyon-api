package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class Franchise {
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private List<Character> characters;
    private List<Concept> concepts;
    private String deck;
    private String description;
    private List<Game> games;
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
