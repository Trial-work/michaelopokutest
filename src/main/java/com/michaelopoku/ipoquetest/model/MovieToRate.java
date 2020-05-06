package com.michaelopoku.ipoquetest.model;

public class MovieToRate {

    private final String name;
    private final int rating;

    public MovieToRate(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
