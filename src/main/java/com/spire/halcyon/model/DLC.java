package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class DLC {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String deck;
    private String description;
    private Game game;
    private String guid;
    @Id
    private String id;
    private Image image;
    private String name;
    private Platform platform;
    @JsonProperty("release_date")
    private String releaseDate;
}
