package com.mgshepherd.backend.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String publisher;
    private Date releaseDate;
    private String genre;

    public Game() {}

    public Game(int id, String name, String publisher, Date releaseDate, String genre) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
