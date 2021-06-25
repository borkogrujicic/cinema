package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Film;

public interface FilmService {
	
	Film findOne (Long id);
	
	List <Film> findAll ();
	
	Film save (Film film);
	
	Film delete (Long id);
	
	Film update (Film film);

}
