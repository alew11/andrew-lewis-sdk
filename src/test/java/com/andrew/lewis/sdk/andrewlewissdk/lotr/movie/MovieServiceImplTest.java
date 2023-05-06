package com.andrew.lewis.sdk.andrewlewissdk.lotr.movie;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.Movie;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.QuoteServiceImpl;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.rest.RestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest(classes = RestConfig.class)
class MovieServiceImplTest {

    MovieServiceImpl movieService;

    @Autowired
    @Qualifier("authRestTemplate")
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(restTemplate);
    }

    @Test
    void testGetMoviesCallReturnsListOfMovies() {
        List<Movie> movies = movieService.getMovies();
        Movie movie = movies.get(0); // appears that movies always get returned in order so leveraging that for test
        assertEquals(movie.get_id(), "5cd95395de30eff6ebccde56");
        assertEquals(movie.getName(), "The Lord of the Rings Series");
        assertEquals(movie.getRuntimeInMinutes(), 558);
        assertEquals(movie.getBudgetInMillions(), 281);
        assertEquals(movie.getBoxOfficeRevenueInMillions(), 2917);
        assertEquals(movie.getAcademyAwardNominations(), 30);
        assertEquals(movie.getAcademyAwardWins(), 17);
        // I assume this fluctates so commenting out for now assertEquals(movie.getRottenTomatoesScore(), 94);

        assertTrue(movies.size() >= 8); // assume movies don't get removed, only added
    }

    @Test
    void testGetMovieByIdCallWhenMovieExists() {
        Movie movie = movieService.getMovieById("5cd95395de30eff6ebccde56");
        assertEquals(movie.get_id(), "5cd95395de30eff6ebccde56");
        assertEquals(movie.getName(), "The Lord of the Rings Series");
        assertEquals(movie.getRuntimeInMinutes(), 558);
        assertEquals(movie.getBudgetInMillions(), 281);
        assertEquals(movie.getBoxOfficeRevenueInMillions(), 2917);
        assertEquals(movie.getAcademyAwardNominations(), 30);
        assertEquals(movie.getAcademyAwardWins(), 17);
        // I assume this fluctates so commenting out for now assertEquals(movie.getRottenTomatoesScore(), 94);
    }

    @Test
    void testGetMovieByIdCallWhenMovieDoesNotExist() {
        assertThrows(HttpServerErrorException.InternalServerError.class, () -> {
            movieService.getMovieById("xxxDoesNotExist");
        });
    }
}