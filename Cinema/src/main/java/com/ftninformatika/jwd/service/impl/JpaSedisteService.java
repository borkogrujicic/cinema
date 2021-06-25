package com.ftninformatika.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Sediste;
import com.ftninformatika.jwd.repository.SedisteRepository;
import com.ftninformatika.jwd.service.SedisteService;

@Service
public class JpaSedisteService implements SedisteService{
	
	@Autowired
	private SedisteRepository sedisteRepository;

	@Override
	public Sediste findOne(Integer id) {
		return sedisteRepository.findOneById(id);
	}

	@Override
	public List<Sediste> findAll() {
		return sedisteRepository.findAll();
	}

}
