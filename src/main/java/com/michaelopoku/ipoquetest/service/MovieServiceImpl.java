package com.michaelopoku.ipoquetest.service;

import com.michaelopoku.ipoquetest.dao.MovieDaoImpl;
import com.michaelopoku.ipoquetest.model.MovieInfo;
import com.michaelopoku.ipoquetest.model.MovieToRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements  MovieService{

    @Autowired
    MovieDaoImpl movieDaoImpl;

    @Autowired
    MovieInfoRetrievalServiceImpl movieInfoRetrievalService;

    public boolean addMovie(MovieToRate movieToRate) {

        Optional<MovieInfo> movieInfo = findMovie(movieToRate);

        if (movieInfo.isEmpty()) {
            movieInfo = movieInfoRetrievalService.retrieveMovieInfo(movieToRate.getName());

        }

        if(movieInfo.isPresent()) {
            movieInfo.get().setRating(movieToRate.getRating());
            return movieDaoImpl.addMovie(movieInfo.get());
        }
        return false;
    }

    public Optional<MovieInfo> findMovie(MovieToRate movieToRate) {
        return movieDaoImpl.findMovie(movieToRate.getName());
    }

    public Optional<MovieInfo> findMovie(String title) {
        return movieDaoImpl.findMovie(title);
    }
}