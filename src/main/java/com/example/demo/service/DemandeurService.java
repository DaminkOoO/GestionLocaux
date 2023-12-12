package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.*;
@Service
public class DemandeurService {
	@Autowired
	private DemandeurRepo demandeurRepo;
	public void supprimerDemandeur(Demandeur demandeur) {
		demandeurRepo.delete(demandeur);
	}
	public boolean supprimerDemandeurID(Long id) {
		
		if(demandeurRepo.existsById(id)) {
			demandeurRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	public Demandeur ajouterDemandeur(Demandeur demandeur) {
		return demandeurRepo.save(demandeur);
	}
	public  Optional<Demandeur> getDemandeur(Long id) {
		return demandeurRepo.findById(id);
	}
	public List<Demandeur> getListDemandeur() {
		return demandeurRepo.findAll();
	}
}
