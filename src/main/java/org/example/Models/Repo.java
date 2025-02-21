package org.example.Models;

import java.util.Objects;

public class Repo {
    private int id;
    private String name;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Repo repo = (Repo) o;
        return id == repo.id && Objects.equals(name, repo.name) && Objects.equals(url, repo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }

    @Override
    public String toString() {
        return "\t  \n  id: " + id + "\n" +
                "\t  name: " + name + '\n' +
                "\t  url: " + url;
    }
}
