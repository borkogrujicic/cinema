package com.ftninformatika.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Sala;
import com.ftninformatika.jwd.model.Sediste;
import com.ftninformatika.jwd.web.dto.SalaDTO;

@Component
public class SalaToSalaDto implements Converter <Sala, SalaDTO>{
	
	@Autowired
	private SedisteToSedisteDto toDto;

	@Override
	public SalaDTO convert(Sala sala) {
		SalaDTO dto = new SalaDTO();
		dto.setId(sala.getId());
		dto.setNaziv(sala.getNaziv());
		List <Sediste> sedista = new ArrayList<>(sala.getSedista());
		dto.setSedista(toDto.convert(sedista));;
		return dto;
	}
	
    public List<SalaDTO> convert(List<Sala> sale){
        List<SalaDTO> dtos = new ArrayList<>();

        for(Sala sala : sale) {
        	dtos.add(convert(sala));
        }

        return dtos;
    }

}
