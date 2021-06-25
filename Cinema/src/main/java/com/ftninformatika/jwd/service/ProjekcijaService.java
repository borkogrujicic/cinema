package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Projekcija;

public interface ProjekcijaService {
	
	Projekcija findOne (Long id);
	List <Projekcija> findAll ();
	
	Projekcija save (Projekcija projekcija);
	Projekcija delete (Long id);
	Projekcija update (Projekcija projekcija);
	
	List <Projekcija> findByFilmId (Long id);

}
