package com.ftninformatika.jwd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sala {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String naziv;
    
    
    @ManyToMany
    @JoinTable(name = "sala_tip", joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tip_id", referencedColumnName = "id"))
    private List <Tip> tipovi = new ArrayList<>();
    
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <Sediste> sedista = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <Projekcija> projekcije = new ArrayList<>();


	public Sala() {
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


	public List<Tip> getTipovi() {
		return tipovi;
	}


	public void setTipovi(List<Tip> tipovi) {
		this.tipovi = tipovi;
	}


	public List<Sediste> getSedista() {
		return sedista;
	}


	public void setSedista(List<Sediste> sedista) {
		this.sedista = sedista;
	}


	public List<Projekcija> getProjekcije() {
		return projekcije;
	}


	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
    
    

}
