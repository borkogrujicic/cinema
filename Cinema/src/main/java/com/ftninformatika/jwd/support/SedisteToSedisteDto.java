package com.ftninformatika.jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Sediste;
import com.ftninformatika.jwd.web.dto.SedisteDTO;

@Component
public class SedisteToSedisteDto implements Converter <Sediste, SedisteDTO>{
	


	@Override
	public SedisteDTO convert(Sediste sediste) {
		SedisteDTO dto = new SedisteDTO();
		dto.setRedniBroj(sediste.getId());
		
		return dto;
	}
	
    public List<SedisteDTO> convert(List<Sediste> sedista){
        List<SedisteDTO> dtos = new ArrayList<>();

        for(Sediste sediste : sedista) {
        	dtos.add(convert(sediste));
        }

        return dtos;
    }

}
