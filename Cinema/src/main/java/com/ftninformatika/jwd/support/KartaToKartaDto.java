package com.ftninformatika.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Karta;
import com.ftninformatika.jwd.web.dto.KartaDTO;

@Component
public class KartaToKartaDto implements Converter<Karta, KartaDTO>{
	
	@Autowired
	private ProjekcijaToProjekcijaDto projekcijaDto;
	
	@Autowired
	private SedisteToSedisteDto sedisteDto;

	@Override
	public KartaDTO convert(Karta karta) {
		KartaDTO dto = new KartaDTO();
		dto.setDatum(karta.getDatum().toString());
		dto.setId(karta.getId());
		dto.setProjekcija(projekcijaDto.convert(karta.getProjekcija()));
		dto.setSediste(sedisteDto.convert(karta.getSediste()));
		return dto;
	}
	
    public List<KartaDTO> convert(List<Karta> karte){
        List<KartaDTO> dtos = new ArrayList<>();

        for(Karta k : karte) {
        	KartaDTO dto = convert(k);
            dtos.add(dto);
        }

        return dtos;
    }

}
