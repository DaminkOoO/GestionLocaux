package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Facture;
import com.example.demo.entites.PlageHoraire;
import com.example.demo.entites.PlageHoraireRepo;
@Service
public class PlageHoraireService {
	@Autowired
	private PlageHoraireRepo plageHoraireRepo;
	public void supprimerPlageHoraire(PlageHoraire plageHoraire) {
	 plageHoraireRepo.delete(plageHoraire);
	}
	public void supprimerPlageHoraireID(Long id) {
	 plageHoraireRepo.deleteById(id);
	}
	public PlageHoraire ajouterPlageHoraire(PlageHoraire plageHoraire) {
	 return plageHoraireRepo.save(plageHoraire);
	}
	public Optional<PlageHoraire> getPlageHoraire(Long id) {
	 return plageHoraireRepo.findById(id);
	}
	public List<PlageHoraire> getListPlageHoraire() {
		return plageHoraireRepo.findAll();
	}

}
