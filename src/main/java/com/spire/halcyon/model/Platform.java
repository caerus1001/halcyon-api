package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonIgnoreProperties({"date_added", "date_last_updated"})
public class Platform {
    private String abbreviation;
    private String aliases;
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private Company company;
    private String deck;
    private String description;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("image_tags")
    private List<ImageTag> imageTags;
    @JsonProperty("install_base")
    private String installBase;
    private String name;
    @JsonProperty("online_support")
    private String onlineSupport;
    @JsonProperty("original_price")
    private String originalPrice;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("site_detail_url")
    private String siteDetailUrl;
}
