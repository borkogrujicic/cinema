package com.ftninformatika.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Karta;
import com.ftninformatika.jwd.model.Projekcija;
import com.ftninformatika.jwd.model.Sala;
import com.ftninformatika.jwd.repository.KartaRepository;
import com.ftninformatika.jwd.service.KartaService;

@Service
public class JpaKartaService implements KartaService{
	
	@Autowired
	private KartaRepository kartaRepository;

	@Override
	public Karta save(Karta karta) {
		Projekcija projekcija = karta.getProjekcija();
		Sala sala = projekcija.getSala();
		
		
		
		return null;
	}

	@Override
	public Karta findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Karta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Karta> findByProjekcijaId(Long projekcijaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
