package com.michaelopoku.ipoquetest.controller;

import com.michaelopoku.ipoquetest.model.RatedMovie;
import com.michaelopoku.ipoquetest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/add")
    public HttpStatus add(@RequestBody RatedMovie ratedMovie) {
        movieService.addMovie(ratedMovie);
        return HttpStatus.CONFLICT;
    }
}
