package com.ftninformatika.jwd.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projekcija {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Film film;
    
    @ManyToOne
    private Tip tip;
    
    @ManyToOne
    private Sala sala;
    
    @Column(name="datum_vreme")
    private LocalDateTime datumIVreme;
    
    @Column
    private double cena;
    
    @OneToMany(mappedBy = "projekcija", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set <Karta> karte = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "projekcija_tip", joinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tip_id", referencedColumnName = "id"))
    private List <Tip> tipovi = new ArrayList<>();

	public Projekcija() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public LocalDateTime getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(LocalDateTime datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Set<Karta> getKarte() {
		return karte;
	}

	public void setKarte(Set<Karta> karte) {
		this.karte = karte;
	}

	public List<Tip> getTipovi() {
		return tipovi;
	}

	public void setTipovi(List<Tip> tipovi) {
		this.tipovi = tipovi;
	}
	
	
    

}
