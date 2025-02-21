package org.example.Models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private String id;
    private String type;
    private Repo repo;

    @SerializedName("public")
    private boolean isPublic;

    private LocalDateTime created_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return isPublic == event.isPublic && Objects.equals(id, event.id) && Objects.equals(type, event.type) && Objects.equals(repo, event.repo) && Objects.equals(created_at, event.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, repo, isPublic, created_at);
    }

    @Override
    public String toString() {
        return "Event: \n" +
                "\tid: " + id + "\n" +
                "\ttype: " + type + "\n" +
                "\trepo: " + repo + "\n" +
                "\tisPublic: " + isPublic + "\n" +
                "\tcreate_at: " + created_at + "\n";
    }

}
