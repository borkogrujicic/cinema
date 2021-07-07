package com.ftninformatika.jwd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Film;
import com.ftninformatika.jwd.repository.FilmRepository;
import com.ftninformatika.jwd.service.FilmService;

@Service
public class JpaFilmService implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public Film findOne(Long id) {
		return filmRepository.findOneById(id);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	public Film save(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Film delete(Long id) {
		Optional <Film> film = filmRepository.findById(id);
		if (film.isPresent()) {
			filmRepository.deleteById(id);
			return film.get();
		}
		return null;
	}

	@Override
	public Film update(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Iterable<Film> findAllMovies() {
		return filmRepository.findAll();
	}

}
