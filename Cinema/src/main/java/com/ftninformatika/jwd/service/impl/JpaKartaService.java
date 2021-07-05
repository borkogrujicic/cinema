package com.ftninformatika.jwd.service.impl;

import java.time.LocalDate;
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
		karta.setDatum(LocalDate.now());
		Projekcija projekcija = karta.getProjekcija();
		if (projekcija.getDatumIVreme().isBefore(LocalDateTime.now())) {
			return null;
		}
		List <Karta> karteZaProjekciju = kartaRepository.findByProjekcijaId(karta.getProjekcija().getId());
		for (int i = 0; i < karteZaProjekciju.size(); i++) {
			if (karteZaProjekciju.get(i).getSediste() == karta.getSediste()) {
				return null;
			}
		}
		projekcija.dodajKartu(karta);
		kartaRepository.save(karta);		
		return karta;
	}

	@Override
	public Karta findOne(Long id) {
		return kartaRepository.findOneById(id);
	}

	@Override
	public List<Karta> findAll() {
		return kartaRepository.findAll();
	}

	@Override
	public List<Karta> findByProjekcijaId(Long projekcijaId) {
		return kartaRepository.findByProjekcijaId(projekcijaId);
	}

}
