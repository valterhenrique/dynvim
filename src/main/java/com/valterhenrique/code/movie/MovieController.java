package com.valterhenrique.code.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1")
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService service;

    @RequestMapping(path = "/Movie", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> list() {

        log.trace("Entering list()");
        List<Movie> Movies = service.list();
        if (Movies.isEmpty()) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(Movies, OK);
    }

    @RequestMapping(path = "/Movie/{title}", method = RequestMethod.GET)
    public ResponseEntity<Movie> read(@PathVariable String title) {

        log.trace("Entering read() with {}", title);
        return service.read(title)
                .map(Movie -> new ResponseEntity<>(Movie, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @RequestMapping(path = "/Movie/{title}/{timestamp}", method = RequestMethod.GET)
    public ResponseEntity<Movie> read(@PathVariable String title, @PathVariable String timestamp) {

        log.trace("Entering read() with {}", title);
        return service.read(title, timestamp)
                .map(Movie -> new ResponseEntity<>(Movie, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @RequestMapping(path = "/Movie", method = RequestMethod.POST)
    public ResponseEntity<Movie> create(@RequestBody @Valid Movie Movie) {

        log.trace("Entering create() with {}", Movie);
        return service.create(Movie)
                .map(newMovieData -> new ResponseEntity<>(newMovieData, CREATED))
                .orElse(new ResponseEntity<>(CONFLICT));
    }

    @RequestMapping(path = "/Movie/{title}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> put(@PathVariable String title, @RequestBody Movie Movie) {

        log.trace("Entering put() with {}, {}", title, Movie);
        return service.replace(Movie.withTitle(title))
                .map(newMovieData -> new ResponseEntity<>(newMovieData, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @RequestMapping(path = "/Movie/{title}", method = RequestMethod.PATCH)
    public ResponseEntity<Movie> patch(@PathVariable String title, @RequestBody Movie Movie) {

        log.trace("Entering patch() with {}, {}", title, Movie);
        return service.update(Movie.withTitle(title))
                .map(newMovieData -> new ResponseEntity<>(newMovieData, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @RequestMapping(path = "/Movie/{title}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String title) {

        log.trace("Entering delete() with {}", title);
        return service.delete(title) ?
                new ResponseEntity<>(NO_CONTENT) :
                new ResponseEntity<>(NOT_FOUND);
    }
}