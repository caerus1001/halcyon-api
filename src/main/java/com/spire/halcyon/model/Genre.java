package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated", "site_detail_url"})
public class Genre {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String deck;
    private String description;
    private String guid;
    @Id
    private String id;
    private Image image;
    private String name;
}
