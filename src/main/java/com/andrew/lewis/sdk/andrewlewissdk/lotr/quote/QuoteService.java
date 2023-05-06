package com.andrew.lewis.sdk.andrewlewissdk.lotr.quote;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> getQuotesByMovie(final String movieId);

    List<Quote> getAllQuotes();

    Quote getQuoteById(final String quoteId);
}
