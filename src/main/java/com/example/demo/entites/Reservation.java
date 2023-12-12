package com.example.demo.entites;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long numReservation;
	@OneToOne
	private Facture facture;
	@ManyToOne
	private Salle salle;
	@ManyToOne
	private PlageHoraire plageHoraire;
	@ManyToOne
	private Demandeur demandeur;
	
	private String etat = "confirmer";
	
	public Demandeur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}
	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Reservation( Facture facture) {
		super();
		this.facture = facture;
	}
	public Reservation() {}
	public Reservation(Facture facture, Salle salle, PlageHoraire plageHoraire, Demandeur demandeur, String etat) {
		super();
		this.facture = facture;
		this.salle = salle;
		this.plageHoraire = plageHoraire;
		this.demandeur = demandeur;
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Reservation [numReservation=" + numReservation + ", facture=" + facture + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(numReservation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(numReservation, other.numReservation);
	}
	public Long getNumReservation() {
		return numReservation;
	}
	public void setNumReservation(Long numReservation) {
		this.numReservation = numReservation;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public double CalculPrixLocation() {
		if(this.salle.getSuperficie()<=200) {
			if(this.plageHoraire.getHeureFin()-this.plageHoraire.getHeureDebut()>10)
				return 1000;
			else
				return 600;
		
		}else
			if(this.plageHoraire.getHeureFin()-this.plageHoraire.getHeureDebut()>10)
				return 1500;
			else
				return 1300;
	}
	public boolean annuler() {
		if(!this.etat.equals("confirmer")) {
			this.etat="Annulé";
			return true;
			
		}
		
		return false;
	}
	public boolean confirmer() {
		if(!this.etat.equals("Annulé")) {
			this.etat="confirmer";
			return true;
			
		}
		return false;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}

}
