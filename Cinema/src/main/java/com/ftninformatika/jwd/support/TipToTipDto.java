package com.ftninformatika.jwd.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Tip;
import com.ftninformatika.jwd.web.dto.TipDTO;

@Component
public class TipToTipDto implements Converter<Tip, TipDTO>{

	@Override
	public TipDTO convert(Tip tip) {
		TipDTO dto = new TipDTO();
		dto.setId(tip.getId());
		dto.setNaziv(tip.getNaziv());
		return dto;
	}

}
