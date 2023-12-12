package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Demandeur;
import com.example.demo.entites.DemandeurRepo;
import com.example.demo.entites.Facture;
import com.example.demo.entites.FactureRepo;
@Service
public class FactureService {
	@Autowired
	private FactureRepo factureRepo;
	public void supprimerFacture(Facture facture) {
	 factureRepo.delete(facture);
	}
	public void supprimerFactureID(Long id) {
	 factureRepo.deleteById(id);
	}
	public Facture ajouterFacture(Facture facture) {
	 return factureRepo.save(facture);
	}
	public Optional<Facture> getFacture(Long id) {
	 return factureRepo.findById(id);
	}
	public List<Facture> getListFacture() {
		return factureRepo.findAll();
	}
}

