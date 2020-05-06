package com.michaelopoku.ipoquetest.controller;

import com.michaelopoku.ipoquetest.model.MovieInfo;
import com.michaelopoku.ipoquetest.model.MovieToRate;
import com.michaelopoku.ipoquetest.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieServiceImpl;

    @PostMapping("/add")
    public HttpStatus add(@RequestBody MovieToRate movieToRate) {
        if (movieServiceImpl.addMovie(movieToRate)) {
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping("/find")
    public ResponseEntity<MovieInfo> find(@RequestParam String title) {
        Optional<MovieInfo> movieInfo = movieServiceImpl.findMovie(title);
        if (movieInfo.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(movieInfo.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
