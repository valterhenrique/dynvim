package com.valterhenrique.code.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSearchRepository extends JpaRepository<MovieSearch, Long> {
}
