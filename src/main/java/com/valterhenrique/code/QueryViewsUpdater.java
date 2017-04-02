package com.valterhenrique.code;

import com.valterhenrique.code.mysql.MovieSearch;
import com.valterhenrique.code.mysql.MovieSearchRepository;
import com.valterhenrique.code.processing.VimeoViewsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class QueryViewsUpdater {

	private static final Logger log = LoggerFactory.getLogger(QueryViewsUpdater.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	private final MovieSearchRepository movieSearchRepo;
	private VimeoViewsQuery vimeoViewsQuery;

	@Autowired
	public QueryViewsUpdater(MovieSearchRepository movieSearchRepo, VimeoViewsQuery vimeoViewsQuery) {
		this.movieSearchRepo = movieSearchRepo;
		this.vimeoViewsQuery = vimeoViewsQuery;
	}

	// TODO set to ~1 hour
	@Scheduled(fixedRate = 60_000)
	public void reportCurrentTime() {
		log.info("Starting views queries at {}.", dateTimeFormatter.format(LocalDateTime.now()));
		List<MovieSearch> allMovieSearches = movieSearchRepo.findAll();

		// TODO query for all here, but since we have a rate limit of 100, we use less for development
		for (int i = 0; i < 3; i++) {
			vimeoViewsQuery.add(allMovieSearches.get(i));
		}
	}

}
