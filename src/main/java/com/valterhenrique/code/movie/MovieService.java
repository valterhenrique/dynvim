package com.valterhenrique.code.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.amazonaws.util.StringUtils.isNullOrEmpty;

@Service
public class MovieService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieRepository repository;

    public Optional<Movie> read(String name) {

        log.trace("Entering read() with {}", name);
        return repository.read(name);
    }

    public Optional<Movie> read(String name, String timeStamp) {

        log.trace("Entering read() with {} {}", name, timeStamp);
        return repository.read(name, timeStamp);
    }

    public Optional<Movie> create(Movie movie) {

        log.trace("Entering create() with {}", movie);
        if (repository.read(movie.getTitle(), movie.getTimeStamp()).isPresent()) {
            log.warn("movie {} not found", movie.getTitle());
            return Optional.empty();
        }
        repository.save(movie);
        return Optional.of(movie);
    }

    public Optional<Movie> replace(Movie newMovieData) {

        log.trace("Entering replace() with {}", newMovieData);
        Optional<Movie> existingMovie = repository.read(newMovieData.getTitle());
        if (!existingMovie.isPresent()) {
            log.warn("Movie {} not found", newMovieData.getTitle());
            return Optional.empty();
        }
        Movie Movie = existingMovie.get();
        Movie.setTimeStamp(newMovieData.getTimeStamp());
        repository.save(Movie);
        return Optional.of(Movie);
    }

    public Optional<Movie> update(Movie newMovieData) {

        log.trace("Entering update() with {}", newMovieData);
        Optional<Movie> existingMovie = repository.read(newMovieData.getTitle());
        if (!existingMovie.isPresent()) {
            log.warn("Movie {} not found", newMovieData.getTitle());
            return Optional.empty();
        }
        Movie Movie = existingMovie.get();
        if (!isNullOrEmpty(newMovieData.getTimeStamp())) {
            Movie.setTimeStamp(newMovieData.getTimeStamp());
        }

        repository.save(Movie);
        return Optional.of(Movie);
    }

    public boolean delete(String name) {

        log.trace("Entering delete() with {}", name);
        if (!repository.read(name).isPresent()) {
            log.warn("Movie {} not found", name);
            return false;
        }
        repository.delete(name);
        return true;
    }

    public List<Movie> list() {

        log.trace("Entering list()");
        return repository.readAll();
    }
}
