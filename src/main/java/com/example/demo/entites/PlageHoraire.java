package com.example.demo.entites;

import java.time.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class PlageHoraire {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;

	private LocalDate date;
	private int heureDebut;
	private int heureFin;
	@OneToMany(mappedBy = "plageHoraire")
	private Collection<Reservation> reservations= new HashSet<>();
	public PlageHoraire(LocalDate date, int heureDebut, int heureFin) {
		super();
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	public PlageHoraire() {}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "PlageHoraire [date=" + date + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, heureDebut, heureFin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageHoraire other = (PlageHoraire) obj;
		return Objects.equals(date, other.date) && Objects.equals(heureDebut, other.heureDebut)
				&& Objects.equals(heureFin, other.heureFin);
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}
	public int getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}
	public boolean reserverPlage(Reservation r) {
		if(estLibre()) {
			if(reservations.contains(r))
				return false;
			else {
				r.setPlageHoraire(this);
				reservations.add(r);
				return true;
			}
		}
		return false;
	}
	public boolean libererPlage() {
		for (Reservation reservation : reservations) {
			if(reservation.getPlageHoraire().equals(this)) {
				reservation.setPlageHoraire(null);
				return true;				
			}
		}
		return false;
	}
	public boolean estLibre() {
		for (Reservation reservation : reservations) {
			if(reservation.getPlageHoraire().equals(this))
				return false;
		}
		return true;
	}
}
