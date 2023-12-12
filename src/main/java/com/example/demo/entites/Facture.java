package com.example.demo.entites;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@Column(name="num",nullable=false,length = 150)
	private Long num;
	@Column(name="montant",nullable=false,length = 150)
	private double montant;
	@Column(name="date",nullable=false,length = 150)
	private LocalDate date = LocalDate.now();
	private boolean emmet=false;
	
	
	public boolean isEmmet() {
		return emmet;
	}
	public void setEmmet(boolean emmet) {
		this.emmet = emmet;
	}
	public Facture() {}
	public Facture( double montant, LocalDate date) {
		super();
		this.montant = montant;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Facture [num=" + num + ", montant=" + montant + ", date=" + date + "]";
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
		Facture other = (Facture) obj;
		return Objects.equals(num, other.num);
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void emettre() {
		this.emmet=true;
	}
	public void imprimer() {
		System.out.println("Entrain d'imprimer!");
	}
}
