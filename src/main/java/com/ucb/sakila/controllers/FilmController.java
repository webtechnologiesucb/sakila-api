package com.ucb.sakila.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ucb.sakila.models.Film;
import com.ucb.sakila.repositories.FilmRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Películas", description = "Endpoints para gestionar películas")
@RestController
@RequestMapping("/api/films")
public class FilmController {
	@Autowired
	private FilmRepository filmRepository;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Film> getFilms() {
		return filmRepository.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> getFilmById(@PathVariable("id") Long id) {
		return filmRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}