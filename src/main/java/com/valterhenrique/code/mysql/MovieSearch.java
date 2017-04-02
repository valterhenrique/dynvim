package com.valterhenrique.code.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MovieSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String movieTitle;

	@NotNull
	private String searchTerm;

	protected MovieSearch() {
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "MovieSearch{" + "id=" + id + ", movieTitle='" + movieTitle + '\'' + ", searchTerm='" + searchTerm + '\''
				+ '}';
	}

}
