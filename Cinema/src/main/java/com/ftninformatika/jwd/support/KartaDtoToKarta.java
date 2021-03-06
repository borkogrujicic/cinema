package com.ftninformatika.jwd.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Karta;
import com.ftninformatika.jwd.service.KartaService;
import com.ftninformatika.jwd.service.ProjekcijaService;
import com.ftninformatika.jwd.service.SedisteService;
import com.ftninformatika.jwd.web.dto.KartaDTO;

@Component
public class KartaDtoToKarta implements Converter<KartaDTO, Karta>{
	
	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteDtoToSediste toSediste;

	@Override
	public Karta convert(KartaDTO dto) {
		Karta karta = new Karta();
		
		if (dto.getId() != null) {
			karta = kartaService.findOne(dto.getId());
		} 
		
		if (karta == null) {
			karta = new Karta();
		}
		
		karta.setDatum(LocalDate.now());
		karta.setProjekcija(projekcijaService.findOne(dto.getProjekcijaId()));
		karta.setSediste(toSediste.convert(dto.getSedista()));
	
		return karta;
	}
	
//    private LocalDate getLocalDate(String datumS) throws DateTimeParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate datum = LocalDate.parse(datumS, formatter);
//        return datum;
//    }	

}
