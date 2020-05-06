package com.michaelopoku.ipoquetest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.michaelopoku.ipoquetest.model.MovieInfo;

import java.util.Optional;

public interface MovieInfoRetrievalService {
    Optional<MovieInfo> retrieveMovieInfo(String name);
    MovieInfo mapJsonToMovieInfo(String json) throws JsonProcessingException;
}
