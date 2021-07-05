package com.ftninformatika.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Karta;
import com.ftninformatika.jwd.web.dto.KartaDTO;

@Component
public class KartaToKartaDto implements Converter<Karta, KartaDTO>{
	

	@Override
	public KartaDTO convert(Karta karta) {
		KartaDTO dto = new KartaDTO();
		dto.setDatum(karta.getDatum().toString());
		dto.setId(karta.getId());
		dto.setProjekcijaDatum(karta.getProjekcija().getDatumIVreme().toString());
		dto.setProjekcijaFilm(karta.getProjekcija().getFilm().getNaziv());
		dto.setProjekcijaId(karta.getProjekcija().getId());
		dto.setSedisteId(karta.getSediste().getId());
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
