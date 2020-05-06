package com.michaelopoku.ipoquetest.service;

import com.michaelopoku.ipoquetest.dao.MovieDaoImpl;
import com.michaelopoku.ipoquetest.model.MovieInfo;
import com.michaelopoku.ipoquetest.model.MovieToRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MovieServiceImplTest {

    @Mock
    MovieDaoImpl movieDaoImpl;

    @Mock
    MovieInfoRetrievalServiceImpl movieInfoRetrievalService;

    @InjectMocks
    MovieServiceImpl movieService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testaddMovieWhenSwapiRetrievalSuccessfull() {
        MovieToRate movieToRate = new MovieToRate("Some title", 5);

        when(movieDaoImpl.findMovie(movieToRate.getName())).thenReturn(Optional.empty());
        MovieInfo movieInfo = new MovieInfo("some title", 42, "bla", "director",
                "producer", "rel_date", "url list of characters");
        when(movieInfoRetrievalService.retrieveMovieInfo(movieToRate.getName())).thenReturn(Optional.of(movieInfo));
        when(movieDaoImpl.addMovie(movieInfo)).thenReturn(true);

        boolean outcome = movieService.addMovie(movieToRate);

        assertTrue(outcome);

        verify(movieDaoImpl, times(1)).findMovie(movieToRate.getName());
        verify(movieInfoRetrievalService, times(1)).retrieveMovieInfo(movieToRate.getName());
        verify(movieDaoImpl, times(1)).addMovie(movieInfo);
    }

    @Test
    void testDontAddMovieWhenSwapiRetrievalFails() {
        MovieToRate movieToRate = new MovieToRate("Some title", 5);

        when(movieDaoImpl.findMovie(movieToRate.getName())).thenReturn(Optional.empty());
        when(movieInfoRetrievalService.retrieveMovieInfo(movieToRate.getName())).thenReturn(Optional.empty());

        boolean outcome = movieService.addMovie(movieToRate);

        assertFalse(outcome);

        verify(movieDaoImpl, times(1)).findMovie(movieToRate.getName());
        verify(movieInfoRetrievalService, times(1)).retrieveMovieInfo(movieToRate.getName());
        verify(movieDaoImpl, times(0)).addMovie(any(MovieInfo.class));
    }
}