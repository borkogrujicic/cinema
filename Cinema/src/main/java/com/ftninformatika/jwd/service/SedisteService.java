package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Sediste;

public interface SedisteService {
	
	Sediste findOne (Long id);
	
	List <Sediste> findAll ();
	
	List <Sediste> findBySala (Long id);

}
