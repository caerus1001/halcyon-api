package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Image {
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("medium_url")
    private String mediumUrl;
    @JsonProperty("screen_url")
    private String screenUrl;
    @JsonProperty("screen_large_url")
    private String screenLargeUrl;
    @JsonProperty("small_url")
    private String small_url;
    @JsonProperty("super_url")
    private String super_url;
    @JsonProperty("thumb_url")
    private String thumb_url;
    @JsonProperty("tiny_url")
    private String tiny_url;
    @JsonProperty("original")
    private String original;
    @JsonProperty("original_url")
    private String original_url;
    @JsonProperty("image_tags")
    private String imageTags;
    private String tags;
}
