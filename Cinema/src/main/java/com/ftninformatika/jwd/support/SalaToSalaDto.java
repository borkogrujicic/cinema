package com.ftninformatika.jwd.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Sala;
import com.ftninformatika.jwd.web.dto.SalaDTO;

@Component
public class SalaToSalaDto implements Converter <Sala, SalaDTO>{

	@Override
	public SalaDTO convert(Sala sala) {
		SalaDTO dto = new SalaDTO();
		dto.setId(sala.getId());
		dto.setNaziv(sala.getNaziv());
		return dto;
	}

}
