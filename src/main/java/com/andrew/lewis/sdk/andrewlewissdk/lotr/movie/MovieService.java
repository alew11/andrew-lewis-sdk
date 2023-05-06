package com.andrew.lewis.sdk.andrewlewissdk.lotr.movie;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();

    Movie getMovieById(final String movieId);
}
