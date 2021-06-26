package com.ftninformatika.jwd.web.dto;

import java.util.ArrayList;
import java.util.List;

public class SalaDTO {
	
	private Long id;
	private String naziv;
	private List <SedisteDTO> sedista = new ArrayList<>();
	
	
	public SalaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<SedisteDTO> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteDTO> sedista) {
		this.sedista = sedista;
	}
	
	
	
	

}
