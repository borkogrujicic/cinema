package com.ftninformatika.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Film;
import com.ftninformatika.jwd.service.FilmService;
import com.ftninformatika.jwd.web.dto.FilmDTO;

@Component
public class FilmDtoToFilm implements Converter <FilmDTO, Film>{
	
	@Autowired
	private FilmService filmService;

	@Override
	public Film convert(FilmDTO dto) {
		Film film = null;
		
		if (dto.getId() != null) {
			film = filmService.findOne(dto.getId());
		}
		
		if (film == null) {
			film = new Film ();
		}
		
		film.setNaziv(dto.getNaziv());
		film.setDistributer(dto.getDistributer());
		film.setGlumci(dto.getGlumci());
		film.setGodinaProizvodnje(dto.getGodinaProizvodnje());
		film.setOpis(dto.getOpis());
		film.setReziser(dto.getReziser());
		film.setTrajanje(dto.getTrajanje());
		film.setZemljaPorekla(dto.getZemljaPorekla());
		film.setZanrovi(dto.getZanrovi());
		
			
		return film;
	}

}
