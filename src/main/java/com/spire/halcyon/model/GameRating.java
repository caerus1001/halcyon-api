package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GameRating {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String guid;
    @Id
    private String id;
    private Image image;
    private String name;
    @JsonProperty("rating_board")
    private RatingBoard ratingBoard;
}
