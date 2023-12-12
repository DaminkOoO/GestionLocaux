package com.example.demo.entites;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Demandeur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long code;
	private String nom;
	private String adresse;
	@OneToMany(mappedBy = "demandeur")
	private Collection<Reservation> reservations= new HashSet<>();
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demandeur other = (Demandeur) obj;
		return Objects.equals(code, other.code);
	}
	@Override
	public String toString() {
		return "Demandeur [code=" + code + ", nom=" + nom + ", adresse=" + adresse + ", reservations=" + reservations
				+ "]";
	}
	public Demandeur() {
		
	}
	public Demandeur(String nom, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
	}

}
