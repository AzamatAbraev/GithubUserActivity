package org.example.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSyntaxException;
import org.example.Models.Event;
import org.example.Models.User;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class GithubClient {
    private final HttpClient httpClient;
    private static final String BASE_URL = "https://api.github.com/";

    public GithubClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public User getUser(String username) {
        String url = BASE_URL + "users/" + username;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();

            if (response.statusCode() != 200) {
                return null;
            }

            return new Gson().fromJson(response.body(), User.class);
        } catch (Exception e) {
            return null;
        }
    }

    public Event[] getEvents(String username) {
        String url = BASE_URL + "users/" + username + "/events";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();
            if (response.statusCode() != 200) return null;

            Gson GSON = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                    ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();

            return GSON.fromJson(response.body(), Event[].class);
        } catch(JsonSyntaxException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception fetching events: " + e.getMessage());
        }

        return null;
    }

}
