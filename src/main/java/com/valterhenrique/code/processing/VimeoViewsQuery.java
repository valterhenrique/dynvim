package com.valterhenrique.code.processing;

import com.clickntap.vimeo.Vimeo;
import com.clickntap.vimeo.VimeoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.valterhenrique.code.json.VimeoHeader;
import com.valterhenrique.code.json.VimeoJsonResult;
import com.valterhenrique.code.mysql.MovieSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Component
public class VimeoViewsQuery {

	private static final Logger log = LoggerFactory.getLogger(VimeoViewsQuery.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();
	// TODO put token in properties file
	private static final Vimeo vimeo = new Vimeo("7449517de7593c8f840df34488e40fa4");

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1,
			new ThreadFactoryBuilder().setDaemon(true).setNameFormat("failAfter-%d").build());

	private VimeoViewsSave vimeoViewsSave;

	public VimeoViewsQuery(VimeoViewsSave vimeoViewsSave) {
		this.vimeoViewsSave = vimeoViewsSave;
	}

	public void add(MovieSearch movieSearch) {
		CompletableFuture<VimeoViewsResult> viewsResultFuture =
				within(asyncViewsResult().apply(movieSearch), Duration.ofSeconds(5));

		viewsResultFuture.thenAccept(vimeoViewsSave::add).exceptionally(throwable -> {
			log.error("Unrecoverable error", throwable);
			return null;
		});
	}

	private static Function<MovieSearch, CompletableFuture<VimeoViewsResult>> asyncViewsResult() {
		return movieSearch -> CompletableFuture.supplyAsync(() -> {
			final String searchTerm = movieSearch.getSearchTerm();
			final String query = searchTerm.replace(" ", "+");
			try {
				final String endpoint = "/videos?page=1&query=" + query;
				log.info("Querying for endpoint: " + endpoint);
				final VimeoResponse videoInfo = vimeo.getVideoInfo(endpoint);

				final String headerJson = videoInfo.getHeaders().toString();
				final VimeoHeader header = objectMapper.readValue(headerJson, VimeoHeader.class);
				// TODO check header/status code for errors and return 'VimeoViewsResult.error(searchTerm)'
				log.info("Status Code: " + videoInfo.getStatusCode());
				log.info(headerJson);

				final String resultJson = videoInfo.getJson().toString();
				final VimeoJsonResult vimeoJsonResult = objectMapper.readValue(resultJson, VimeoJsonResult.class);
				final long views = vimeoJsonResult.getData().stream().mapToLong(data -> {
					final Integer plays = data.getStats().getPlays();
					// TODO not sure if it can return null, so check might be useless and could be removed
					return plays == null ? 0 : plays;
				}).sum();
				return VimeoViewsResult.of(searchTerm, views);
			} catch (IOException e) {
				return VimeoViewsResult.error(searchTerm);
			}
		});
	}

	private static <T> CompletableFuture<T> within(CompletableFuture<T> future, Duration duration) {
		final CompletableFuture<T> timeout = failAfter(duration);
		return future.applyToEither(timeout, Function.identity());
	}

	private static <T> CompletableFuture<T> failAfter(Duration duration) {
		final CompletableFuture<T> promise = new CompletableFuture<>();
		scheduler.schedule(() -> {
			final TimeoutException ex = new TimeoutException("Timeout after " + duration);
			return promise.completeExceptionally(ex);
		}, duration.toMillis(), MILLISECONDS);
		return promise;
	}

}
