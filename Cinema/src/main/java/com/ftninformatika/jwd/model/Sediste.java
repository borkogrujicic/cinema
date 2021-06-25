package com.ftninformatika.jwd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sediste {
	
	@Column(name="redni_broj")
	private int redniBroj;
	
	@ManyToOne
	private Sala sala;
	
	@OneToOne(mappedBy = "sediste")
	private Karta karta;

	public Sediste() {
		super();
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Karta getKarta() {
		return karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}
	
	
	
	

}
