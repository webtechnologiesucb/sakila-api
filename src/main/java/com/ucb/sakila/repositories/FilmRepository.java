package com.ucb.sakila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ucb.sakila.models.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
