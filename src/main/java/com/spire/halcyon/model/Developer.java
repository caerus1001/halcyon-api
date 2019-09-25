package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"site_detail_url"})
public class Developer {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    @Id
    private String id;
    private String name;
}
