package com.michaelopoku.ipoquetest.dao;

import com.michaelopoku.ipoquetest.model.MovieInfo;

import java.util.Optional;

public interface MovieDao {
    boolean addMovie(MovieInfo movieToRate);
    Optional<MovieInfo> findMovie(String name);
}
