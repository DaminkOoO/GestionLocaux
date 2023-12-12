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
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long num;
	private double superficie;
	@OneToMany(mappedBy = "salle")
	private Collection<Reservation> reservations= new HashSet<>();
	
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Salle() {}
	public Salle(Long num, double superficie) {
		super();
		this.num = num;
		this.superficie = superficie;
	}
	public Salle(double superficie, Collection<Reservation> reservations) {
		super();
		this.superficie = superficie;
		this.reservations = reservations;
	}
	@Override
	public String toString() {
		return "Salle [num=" + num + ", superficie=" + superficie + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(num, other.num);
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public Salle(double superficie) {
		super();
		this.superficie = superficie;
	}
	
}
