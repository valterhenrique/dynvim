package com.valterhenrique.code;

import com.valterhenrique.code.movie.Movie;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void postShouldCreateMovieWithTimeStampAndRespondWithCreated() {
        Movie movie = new Movie().withTitle(randomUUID().toString()).withTimeStamp(DateTime.now().toString());
        ResponseEntity<Movie> result = restTemplate.postForEntity("/v1/Movie/", movie, Movie.class);

        assertThat(result.getStatusCode(), is(CREATED));
        assertThat(result.getBody(), is(equalTo(movie)));
    }

    @Test
    public void postShouldNotCreateMovieIfAlreadyExistsAndRespondWithConflict() throws Exception {

        Movie movie = new Movie().withTitle(randomUUID().toString()).withTimeStamp(DateTime.now().toString());
        restTemplate.postForEntity("/v1/Movie", movie, Movie.class);
        ResponseEntity<Movie> result = restTemplate.postForEntity("/v1/Movie", movie, Movie.class);
        assertThat(result.getStatusCode(), is(CONFLICT));
    }

    @Test
    public void postShouldRespondWithBadRequestIfMovieTitleNotPassed() throws Exception {

        Movie movie = new Movie().withTimeStamp(LocalDate.now().toString());
        restTemplate.postForEntity("/v1/Movie", movie, Movie.class);
        ResponseEntity<Movie> result = restTemplate.postForEntity("/v1/Movie", movie, Movie.class);
        assertThat(result.getStatusCode(), is(BAD_REQUEST));
    }

    @Test
    public void getShouldReturnPreviouslyCreatedMovies() throws Exception {

        Movie movie1 = new Movie().withTitle(randomUUID().toString()).withTimeStamp(LocalDate.now().toString());
        Movie movie2 = new Movie().withTitle(randomUUID().toString()).withTimeStamp(LocalDate.now().toString());
        restTemplate.postForEntity("/v1/Movie", movie1, Movie.class);
        restTemplate.postForEntity("/v1/Movie", movie2, Movie.class);
        ResponseEntity<Movie[]> result = restTemplate.getForEntity("/v1/Movie", Movie[].class);
        assertThat(result.getStatusCode(), is(OK));
        assertThat(asList(result.getBody()), hasItems(movie1, movie2));
    }

    @Test
    public void getByTitleShouldRespondWithNotFoundForMovieThatDoesNotExist() throws Exception {

        String movieTitle = randomUUID().toString();
        String timestamp = LocalDate.now().toString();
        ResponseEntity<Movie> result = restTemplate.getForEntity("/v1/Movie/" + movieTitle + "/" + timestamp, Movie.class);
        assertThat(result.getStatusCode(), is(NOT_FOUND));
    }

    // TODO: implement the following tests
    //    putShouldReplyWithNotFoundForMovieThatDoesNotExist
    //    putShouldReplaceExistingMovieValues
    //    patchShouldReplyWithNotFoundForMovieThatDoesNotExist
    //    patchShouldAddNewValuesToExistingMovieValues
    //    deleteShouldReturnNotFoundWhenMovieDoesNotExist
    //    deleteShouldRemoveExistingMovieAndRespondWithNoContent

}