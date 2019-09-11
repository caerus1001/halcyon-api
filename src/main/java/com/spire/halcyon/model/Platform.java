package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"api_detail_url", "site_detail_url", "company", "online_support", "date_added", "image_tags", "install_base", "date_last_updated"})
public class Platform {
    @Id
    private String id;
    private String name;
    private String abbreviation;
    private String guid;
    private Image image;
    @JsonProperty("original_price")
    private String originalPrice;
    @JsonProperty("release_date")
    private String releaseDate;
    private String aliases;
    private String deck;
    private String description;
}
