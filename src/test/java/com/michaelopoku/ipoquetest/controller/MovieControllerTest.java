package com.michaelopoku.ipoquetest.controller;

import com.michaelopoku.ipoquetest.model.MovieToRate;
import com.michaelopoku.ipoquetest.service.MovieService;
import com.michaelopoku.ipoquetest.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MovieControllerTest {

    @Mock
    MovieServiceImpl movieService;

    @InjectMocks
    MovieController movieController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddRatedMovieSuccess() {
        MovieToRate movieToRate = new MovieToRate("Some title", 5);

        when(movieService.addMovie(movieToRate)).thenReturn(true);

        HttpStatus outcomeStatusCode = movieController.add(movieToRate);

        assertEquals(HttpStatus.OK, outcomeStatusCode);
        verify(movieService, times(1)).addMovie(movieToRate);
    }

    @Test
    public void testAddRatedMovieFailed() {
        MovieToRate movieToRate = new MovieToRate("Some title", 1);

        when(movieService.addMovie(movieToRate)).thenReturn(false);

        HttpStatus outcomeStatusCode = movieController.add(movieToRate);

        assertEquals(HttpStatus.NOT_FOUND, outcomeStatusCode);
        verify(movieService, times(1)).addMovie(movieToRate);
    }
}