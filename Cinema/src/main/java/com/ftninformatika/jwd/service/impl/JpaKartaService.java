package com.ftninformatika.jwd.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Karta;
import com.ftninformatika.jwd.model.Projekcija;
import com.ftninformatika.jwd.repository.KartaRepository;
import com.ftninformatika.jwd.service.KartaService;

@Service
public class JpaKartaService implements KartaService{
	
	@Autowired
	private KartaRepository kartaRepository;
	

	@Override
	public Karta save(Karta karta) {
		Projekcija projekcija = karta.getProjekcija();
		if (projekcija.getDatumIVreme().isBefore(LocalDateTime.now())) {
			return null;
		}
		List <Karta> karte = kartaRepository.findByProjekcijaId(karta.getProjekcija().getId());
		for (int i = 0; i < karte.size(); i++) {
			if (karte.get(i).getSediste() == karta.getSediste()) {
				return null;
			}
		}
		projekcija.dodajKartu(karta);
		kartaRepository.save(karta);		
		return karta;
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
