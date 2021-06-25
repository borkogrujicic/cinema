package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Sediste;

public interface SedisteService {
	
	Sediste findOne (Integer id);
	
	List <Sediste> findAll ();

}
