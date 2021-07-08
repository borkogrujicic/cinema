package com.ftninformatika.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Projekcija;
import com.ftninformatika.jwd.model.Sala;
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
		
		Sala sala = projekcija.getSala();
		List <Projekcija> projekcije = sala.getProjekcije();
		for (int i = 0; i < projekcije.size(); i++) {
			
		}
		return projekcijaRepository.save(projekcija);
	}

	@Override
	public Projekcija delete(Long id) {
		Projekcija projekcija = projekcijaRepository.findOneById(id);
		if (projekcija != null) {
			projekcija.getFilm().getProjekcije().remove(projekcija);
			projekcija.setFilm(null);
			projekcija.getSala().getProjekcije().remove(projekcija);
			projekcija.setSala(null);
			projekcija.getTip().getProjekcije().remove(projekcija);
			projekcija.setTip(null);
			projekcija = projekcijaRepository.save(projekcija);
			projekcijaRepository.deleteById(id);
			return projekcija;
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

	@Override
	public Page<Projekcija> findAll(int pageNo) {
		return projekcijaRepository.findAll(PageRequest.of(pageNo, 5));
	}

}
