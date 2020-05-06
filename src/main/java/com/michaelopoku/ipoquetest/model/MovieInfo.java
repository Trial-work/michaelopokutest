package com.michaelopoku.ipoquetest.model;

public class MovieInfo {
    private int rating;
    private final String title;
    private final int episode_id;
    private final String opening_crawl;
    private final String director;
    private final String producer;
    private final String release_date;
    private final String characters;

    public MovieInfo(String title, int episode_id, String opening_crawl, String director, String producer, String release_date, String characters) {
        this.title = title;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.characters = characters;
    }

    public String getTitle() {
        return title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getCharacters() {
        return characters;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
