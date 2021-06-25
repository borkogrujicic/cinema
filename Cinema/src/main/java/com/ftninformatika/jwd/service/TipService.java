package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Tip;

public interface TipService {
	
	Tip findOne (Long id);
	
	List <Tip> findAll();

}
