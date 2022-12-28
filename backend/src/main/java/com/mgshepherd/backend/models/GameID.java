package com.mgshepherd.backend.models;

import java.io.Serializable;
import java.util.Objects;

public class GameID implements Serializable {
    private final String name;
    private final String publisher;

    public GameID() {
        this("", "");
    }

    public GameID(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameID other = (GameID) o;
        return this.name.equals(other.name) &&
                this.publisher.equals(other.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.publisher);
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }
}
