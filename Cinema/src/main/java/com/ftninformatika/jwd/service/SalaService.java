package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Sala;

public interface SalaService {
	
	Sala findOne (Long id);
	List <Sala> findAll ();

}
