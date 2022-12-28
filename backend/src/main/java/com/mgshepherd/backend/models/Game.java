package com.mgshepherd.backend.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "Games")
@IdClass(GameID.class)
public class Game {
    @Id
    private String name;
    @Id
    private String publisher;
    private Date releaseDate;
    private String imageUrl;
    private String genre;

    public Game() {}

    public Game(String name, String publisher, Date releaseDate, String imageUrl, String genre) {
        this.name = name;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
