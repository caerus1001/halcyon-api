package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"api_detail_url", "site_detail_url"})
public class Publisher {
    @Id
    private String id;
    private String name;
}
