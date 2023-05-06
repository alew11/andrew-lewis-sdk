package com.andrew.lewis.sdk.andrewlewissdk.lotr.quote;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.MovieServiceImpl;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model.Quote;
import com.andrew.lewis.sdk.andrewlewissdk.lotr.rest.RestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class QuoteServiceImplTest {

    QuoteServiceImpl quoteService;

    @Autowired
    @Qualifier("authRestTemplate")
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        quoteService = new QuoteServiceImpl(restTemplate);
    }

    @Test
    void testGetQuotesByMovieWhenMovieExists() {
        List<Quote> quotes = quoteService.getQuotesByMovie("5cd95395de30eff6ebccde5d");
        Quote quote = quotes.get(0);
        assertEquals(quote.get_id(), "5cd96e05de30eff6ebcce7e9");
        assertEquals(quote.getDialog(), "Deagol!");
        assertEquals(quote.getMovie(), "5cd95395de30eff6ebccde5d");
        assertEquals(quote.getCharacter(), "5cd99d4bde30eff6ebccfe9e");
        assertEquals(quote.getId(), "5cd96e05de30eff6ebcce7e9");
        assertTrue(quotes.size() >= 872); // quotes could grow, but likely no shrink

    }

    @Test
    void testGetQuotesByMovieWhenMovieDoesNotExists() {
        assertThrows(HttpServerErrorException.InternalServerError.class, () -> {
            quoteService.getQuotesByMovie("xxxDoesNotExist");
        });
    }

    @Test
    void testGetAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        Quote quote = quotes.get(0);
        assertEquals(quote.get_id(), "5cd96e05de30eff6ebcce7e9");
        assertEquals(quote.getDialog(), "Deagol!");
        assertEquals(quote.getMovie(), "5cd95395de30eff6ebccde5d");
        assertEquals(quote.getCharacter(), "5cd99d4bde30eff6ebccfe9e");
        assertEquals(quote.getId(), "5cd96e05de30eff6ebcce7e9");
        assertTrue(quotes.size() >= 2384); // quotes could grow, but likely no shrink
    }

    @Test
    void testGetQuoteByQuoteIdWhenQuoteExists() {
        Quote quote = quoteService.getQuoteById("5cd96e05de30eff6ebcce7e9");
        assertEquals(quote.get_id(), "5cd96e05de30eff6ebcce7e9");
        assertEquals(quote.getDialog(), "Deagol!");
        assertEquals(quote.getMovie(), "5cd95395de30eff6ebccde5d");
        assertEquals(quote.getCharacter(), "5cd99d4bde30eff6ebccfe9e");
        assertEquals(quote.getId(), "5cd96e05de30eff6ebcce7e9");
    }

    @Test
    void testGetQuoteByQuoteIdWhenQuoteDoesNotExist() {
        assertThrows(HttpServerErrorException.InternalServerError.class, () -> {
            quoteService.getQuoteById("xxxDoesNotExist");
        });
    }
}