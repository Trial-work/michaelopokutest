package com.michaelopoku.ipoquetest.service;

import com.michaelopoku.ipoquetest.model.MovieInfo;
import com.michaelopoku.ipoquetest.model.MovieToRate;

import java.util.Optional;

public interface MovieService {
    boolean addMovie(MovieToRate movieToRate);
    Optional<MovieInfo> findMovie(MovieToRate movieToRate);
    Optional<MovieInfo> findMovie(String name);
}
