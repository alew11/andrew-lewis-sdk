package com.andrew.lewis.sdk.andrewlewissdk.lotr.quote;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.LotrMovieAPIResponseModel;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model.LotrQuoteAPIResponseModel;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model.Quote;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class QuoteServiceImpl implements QuoteService {

    final RestTemplate restTemplate;

    public QuoteServiceImpl(@Qualifier("authRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Quote> getQuotesByMovie(String movieId) {
        LotrQuoteAPIResponseModel lotrQuoteAPIResponseModel = restTemplate.exchange("https://the-one-api.dev/v2/movie/" + movieId + "/quote", HttpMethod.GET, HttpEntity.EMPTY, LotrQuoteAPIResponseModel.class).getBody();
        return lotrQuoteAPIResponseModel != null ? lotrQuoteAPIResponseModel.getDocs() : null;
    }

    /**
     * Return all quotes for all movies
     *
     * TODO: Feature enhancement: implement paging
     * @return
     */
    @Override
    public List<Quote> getAllQuotes() {
        LotrQuoteAPIResponseModel lotrQuoteAPIResponseModel = restTemplate.exchange("https://the-one-api.dev/v2/quote?limit=2384", HttpMethod.GET, HttpEntity.EMPTY, LotrQuoteAPIResponseModel.class).getBody();
        assert lotrQuoteAPIResponseModel != null;
        return lotrQuoteAPIResponseModel.getDocs();
    }

    @Override
    public Quote getQuoteById(String quoteId) {
        LotrQuoteAPIResponseModel lotrQuoteAPIResponseModel = restTemplate.exchange("https://the-one-api.dev/v2/quote/" + quoteId, HttpMethod.GET, HttpEntity.EMPTY, LotrQuoteAPIResponseModel.class).getBody();
        return lotrQuoteAPIResponseModel != null ? lotrQuoteAPIResponseModel.getDocs().get(0) : null;
    }
}
