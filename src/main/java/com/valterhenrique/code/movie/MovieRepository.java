package com.valterhenrique.code.movie;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DynamoDBMapper dbMapper;

    public List<Movie> readAll() {
        log.trace("Entering readAll()");
        PaginatedList<Movie> results = dbMapper.scan(Movie.class, new DynamoDBScanExpression());
        results.loadAllResults();
        return results;
    }

    public Optional<Movie> read(String title) {
        log.trace("Entering read() with {}", title);
        return Optional.ofNullable(dbMapper.load(Movie.class, title));
    }

    public Optional<Movie> read(String title, String timeStamp) {
        log.trace("Entering read() with {}", title);
        return Optional.ofNullable(dbMapper.load(Movie.class, title, timeStamp));
    }

    public void save(Movie movie) {
        log.trace("Entering save() with {}", movie);
        dbMapper.save(movie);
    }

    public void delete(String title) {
        dbMapper.delete(new Movie().withTitle(title), new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.CLOBBER));
    }
}
