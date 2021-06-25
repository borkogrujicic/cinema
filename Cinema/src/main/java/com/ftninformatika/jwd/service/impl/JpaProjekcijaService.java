package com.ftninformatika.jwd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Projekcija;
import com.ftninformatika.jwd.repository.ProjekcijaRepository;
import com.ftninformatika.jwd.service.ProjekcijaService;

@Service
public class JpaProjekcijaService implements ProjekcijaService{
	
	@Autowired
	private ProjekcijaRepository projekcijaRepository;

	@Override
	public Projekcija findOne(Long id) {
		return projekcijaRepository.findOneById(id);
	}

	@Override
	public List<Projekcija> findAll() {
		return projekcijaRepository.findAll();
	}

	@Override
	public Projekcija save(Projekcija projekcija) {
		return projekcijaRepository.save(projekcija);
	}

	@Override
	public Projekcija delete(Long id) {
		Optional <Projekcija> projekcija = projekcijaRepository.findById(id);
		if (projekcija.isPresent()) {
			projekcijaRepository.deleteById(id);
			return projekcija.get();
		}
		return null;
	}

	@Override
	public Projekcija update(Projekcija projekcija) {
		return projekcijaRepository.save(projekcija);
	}

	@Override
	public List<Projekcija> findByFilmId(Long id) {
		return projekcijaRepository.findByFilmId(id);
	}

}
