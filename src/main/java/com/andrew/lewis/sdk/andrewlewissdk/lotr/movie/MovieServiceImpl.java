package com.andrew.lewis.sdk.andrewlewissdk.lotr.movie;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.LotrMovieAPIResponseModel;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    final RestTemplate restTemplate;

    @Autowired
    public MovieServiceImpl(@Qualifier("authRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Movie> getMovies() {
        LotrMovieAPIResponseModel lotrMovieAPIResponseModel = restTemplate.exchange("https://the-one-api.dev/v2/movie", HttpMethod.GET, HttpEntity.EMPTY, LotrMovieAPIResponseModel.class).getBody();

        return lotrMovieAPIResponseModel != null ? lotrMovieAPIResponseModel.getDocs() : null;
    }

    /**
     * Return movie details, else null if movie id is not in catalog
     * @param movieId id of movie
     * @return
     */
    @Override
    public Movie getMovieById(String movieId) {
        LotrMovieAPIResponseModel lotrMovieAPIResponseModel = restTemplate.exchange("https://the-one-api.dev/v2/movie/" + movieId, HttpMethod.GET, HttpEntity.EMPTY, LotrMovieAPIResponseModel.class).getBody();

        return lotrMovieAPIResponseModel != null ? lotrMovieAPIResponseModel.getDocs().get(0) : null;
    }
}
