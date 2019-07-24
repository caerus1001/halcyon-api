package com.spire.halcyon.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Game {
    @Id
    private String id;
    private String title;
    private List<String> genres;
    private List<String> platforms;

    public Game(String title, List<String> genres, List<String> platforms) {
        this.title = title;
        this.genres = genres;
        this.platforms = platforms;
    }
}
