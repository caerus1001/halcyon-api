package com.spire.halcyon.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.spire.halcyon.model.Game;
import com.spire.halcyon.model.Platform;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class GiantBombClient {
    private final String baseContext = "https://www.giantbomb.com";
    private final String gamesUrl = "/api/games/?api_key=a5613655d4fbe99880d6ce40a22662ae388c0b15&format=json&field_list=id,name,platforms,genres,expected_release_day,expected_release_month,expected_release_year&filter=";
    private final String gameUrl = "/api/game/%d/?api_key=a5613655d4fbe99880d6ce40a22662ae388c0b15&format=json&field_list=id,name,platforms,genres,expected_release_day,expected_release_day,expected_release_month,expected_release_year,image,publishers";
    private final String gamesByPlatform = "/api/games/?api_key=a5613655d4fbe99880d6ce40a22662ae388c0b15&format=json&platforms=%s&field_list=id,name,platforms,genres,expected_release_day,expected_release_month,expected_release_year";
    private final String platformsUrl = "/api/platforms/?api_key=a5613655d4fbe99880d6ce40a22662ae388c0b15&format=json&filter=name:%s";
    private HttpClient httpClient;

    public GiantBombClient() {
        httpClient = HttpClient.newHttpClient();
    }

    public List<Game> getGames(Map<Filters, String> filters) throws Exception {
        int i = 0;
        StringBuilder url = new StringBuilder(baseContext + gamesUrl);
        for(Map.Entry<Filters, String> filter : filters.entrySet()) {
            if(i == 0) {
                url.append(filter.getKey()).append(":").append(filter.getValue());
            } else {
                url.append(",").append(filter.getKey()).append(":").append(filter.getValue());
            }
            i++;
        }
        HttpRequest httpRequest = buildRequest(url.toString(), "GET");

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray resultsArray = new JSONObject(httpResponse.body()).getJSONArray("results");

        ObjectMapper objectMapper = new ObjectMapper();
        List<Game> games = objectMapper.readValue(resultsArray.toString(), TypeFactory.defaultInstance().constructCollectionType(List.class, Game.class));

        return games;
    }

    public Game getGame(String id) throws Exception {
        HttpRequest httpRequest = buildRequest(String.format(baseContext + gameUrl, Integer.parseInt(id)), "GET");

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject resultsArray = new JSONObject(httpResponse.body()).getJSONObject("results");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resultsArray.toString(), Game.class);
    }

    public List<Game> getGamesByPlatforms(List<Platform> platforms) {
        return null;
    }

    public List<Game> getGamesByPlatform(String id) throws Exception {
        HttpRequest httpRequest = buildRequest(String.format(baseContext + gamesByPlatform, id), "GET");

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray resultsArray = new JSONObject(httpResponse.body()).getJSONArray("results");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resultsArray.toString(), TypeFactory.defaultInstance().constructCollectionType(List.class, Game.class));
    }

    public Platform getPlatformByName(String platformName) throws Exception {
        HttpRequest httpRequest = buildRequest(String.format(baseContext + platformsUrl, platformName).replaceAll("\\s", "%20"), "GET");

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray resultsArray = new JSONObject(httpResponse.body()).getJSONArray("results");

        ObjectMapper objectMapper = new ObjectMapper();
        List<Platform> platforms = objectMapper.readValue(resultsArray.toString(), TypeFactory.defaultInstance().constructCollectionType(List.class, Platform.class));

        return platforms.stream().filter(platform -> platform.getName().equals(platformName)).findFirst().orElseThrow();
    }

    private HttpRequest buildRequest(String requestUrl, String method) {
        HttpRequest httpRequest = null;
        switch(method) {
            case "GET":
                httpRequest =
                        HttpRequest
                                .newBuilder()
                                .GET()
                                .uri(URI.create(requestUrl)).build();
                break;
            case "DELETE":
                break;
            case "PUT":
                break;
            case "POST":
                break;
        }
        return httpRequest;
    }

    public static void main(String[] args) throws Exception {
        GiantBombClient giantBombClient = new GiantBombClient();

        Platform platform = giantBombClient.getPlatformByName("Xbox One");
        System.out.println("Platform abbreviation: " + platform.getAbbreviation());
    }
}
