package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Demandeur;
import com.example.demo.entites.Salle;
import com.example.demo.entites.SalleRepo;
@Service
public class SalleService {
	@Autowired
	private SalleRepo salleRepo;
	
	public void supprimerSalle(Salle salle) {
		salleRepo.delete(salle);
	}
	public boolean supprimerSalleID(Long id) {
		if(salleRepo.existsById(id)) {
			salleRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	public Salle ajouterSalle(Salle salle) {
		return salleRepo.save(salle);
	}
	public Optional<Salle> getSalle(Long id) {
		return salleRepo.findById(id);
	}
	public List<Salle> getListSalle() {
		return salleRepo.findAll();
	}
	public List<Salle> getFreeSalle( LocalDate date, int heureDebut, int heureFin){
		return salleRepo.findFreeSalles(date,heureDebut,heureFin);
	}
}
