package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImageTag {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String name;
    private String total;
}
