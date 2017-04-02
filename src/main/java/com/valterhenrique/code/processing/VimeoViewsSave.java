package com.valterhenrique.code.processing;

import com.valterhenrique.code.movie.Movie;
import com.valterhenrique.code.movie.MovieService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class VimeoViewsSave {

	private static final Logger log = LoggerFactory.getLogger(VimeoViewsSave.class);

	@Autowired
	MovieService service;

	void add(VimeoViewsResult result) {
		service.create(new Movie().withTitle(result.getSearchTerm()).withTimeStamp(DateTime.now().toString()));
		log.info("Saving views: " + result);
	}

}
