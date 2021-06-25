package com.ftninformatika.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Tip;
import com.ftninformatika.jwd.repository.TipRepository;
import com.ftninformatika.jwd.service.TipService;

@Service
public class JpaTipService implements TipService{
	
	@Autowired
	private TipRepository tipRepository;

	@Override
	public Tip findOne(Long id) {
		return tipRepository.findOneById(id);
	}

	@Override
	public List<Tip> findAll() {
		return tipRepository.findAll();
	}

}
