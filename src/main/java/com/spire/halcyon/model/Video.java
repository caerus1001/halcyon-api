package com.spire.halcyon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Video {
    @JsonProperty("api_detail_url")
    private String apiDetailUrl;
    private String associations;
    private String deck;
    @JsonProperty("hd_url")
    private String hdUrl;
    @JsonProperty("high_url")
    private String highUrl;
    @JsonProperty("low_url")
    private String lowUrl;
    @JsonProperty("embed_player")
    private String embedPlayer;
    private String guid;
    @Id
    private String id;
    private Image image;
    @JsonProperty("length_seconds")
    private String lengthSeconds;
    private String name;
    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("site_detail_url")
    private String siteDetailUrl;
    private String url;
    private String user;
    @JsonProperty("video_categories")
    private List<VideoCategory> videoCategories;
    @JsonProperty("video_type")
    private String videoType;
    @JsonProperty("video_show")
    private String videoShow;
    @JsonProperty("youtube_id")
    private String youtubeId;
    @JsonProperty("saved_time")
    private String savedTime;
    private String premium;
    private String hosts;
    private String crew;
}
