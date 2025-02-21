package org.example.Models;

import java.util.Objects;

public class User {
    private String login;
    private String id;
    private String url;
    private String location;
    private String email;
    private boolean hireable;
    private String bio;
    private int public_repos;
    private int followers;
    private int following;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isHireable() {
        return hireable;
    }

    public void setHireable(boolean hireable) {
        this.hireable = hireable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return hireable == user.hireable && public_repos == user.public_repos && followers == user.followers && following == user.following && Objects.equals(login, user.login) && Objects.equals(id, user.id) && Objects.equals(url, user.url) && Objects.equals(location, user.location) && Objects.equals(email, user.email) && Objects.equals(bio, user.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, url, location, email, hireable, bio, public_repos, followers, following);
    }

    @Override
    public String toString() {
        return "Username: " +  login + "\n" +
                        "\tid: " + id + "\n" +
                        "\turl: " + url + "\n" +
                        "\tlocation: " + (location != null ? location : "Not available") + "\n" +
                        "\temail: " + email + "\n" +
                        "\thireable: " + (hireable ? "Yes" : "No") + "\n" +
                        "\tbio: " + bio + "\n" +
                        "\tfollowers: " + followers + "\n" +
                        "\tfollowing: " + following + "\n";
    }
}
