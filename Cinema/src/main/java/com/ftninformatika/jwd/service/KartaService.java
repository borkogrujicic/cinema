package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Karta;

public interface KartaService {
	
	Karta save (Karta karta);
	
	Karta findOne (Long id);
	
	List <Karta> findAll ();
	
	List <Karta> findByProjekcijaId (Long projekcijaId);
	


}
