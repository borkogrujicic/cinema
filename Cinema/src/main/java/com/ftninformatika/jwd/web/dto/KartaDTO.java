package com.ftninformatika.jwd.web.dto;

public class KartaDTO {
	
	private Long id;
	private ProjekcijaDTO projekcija;
	private SedisteDTO sediste;
	private String datum;
	
	public KartaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjekcijaDTO getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(ProjekcijaDTO projekcija) {
		this.projekcija = projekcija;
	}

	public SedisteDTO getSediste() {
		return sediste;
	}

	public void setSediste(SedisteDTO sediste) {
		this.sediste = sediste;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
