package com.ftninformatika.jwd.web.dto;

import java.util.ArrayList;
import java.util.List;

public class FilmDTO {
	
	private Long id;
	private String naziv;
	private String reziser;
	private List <String> glumci = new ArrayList<>();
	private List <String> zanrovi = new ArrayList<>();
	private int trajanje;
	private String distributer;
	private String zemljaPorekla;
	private int godinaProizvodnje;
	private String opis;
	
	public FilmDTO() {
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

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public List<String> getGlumci() {
		return glumci;
	}

	public void setGlumci(List<String> glumci) {
		this.glumci = glumci;
	}

	public List<String> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(List<String> zanrovi) {
		this.zanrovi = zanrovi;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getDistributer() {
		return distributer;
	}

	public void setDistributer(String distributer) {
		this.distributer = distributer;
	}

	public String getZemljaPorekla() {
		return zemljaPorekla;
	}

	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	

}
