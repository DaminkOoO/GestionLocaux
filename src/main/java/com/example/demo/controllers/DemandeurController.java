package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entites.Demandeur;
import com.example.demo.entites.Salle;
import com.example.demo.service.DemandeurService;

@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
public class DemandeurController {
	@Autowired
	private DemandeurService demandeurService;
	@GetMapping("/demandeur")
	public List<Demandeur> getDemandeurs() {
	    return demandeurService.getListDemandeur();
	}
	
	 @PostMapping("/demandeur")
	    public ResponseEntity<Salle> addDemandeur(@RequestBody Demandeur nouveauxDemandeur) {
	        Demandeur demandeurAjouter = demandeurService.ajouterDemandeur(nouveauxDemandeur);
	        System.out.println(demandeurAjouter);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

	
	
	@GetMapping("/demandeur/{id}")
	public Optional<Demandeur> getSalle(@PathVariable Long id){
		return demandeurService.getDemandeur(id);
	}
	@DeleteMapping("/demandeur/{id}")
	public ResponseEntity<?> deleteSalle(@PathVariable Long id) {

		if(demandeurService.supprimerDemandeurID(id)) {
	        return new ResponseEntity<>(HttpStatus.OK);

		}else
	        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);

	}
	 @PutMapping("/demandeur/{id}")
	public ResponseEntity<?> replaceEmployee(@RequestBody Demandeur newDemandeur, @PathVariable Long id) {
		 Optional<Demandeur> demandeur= demandeurService.getDemandeur(id);
		 System.out.println(demandeur.get());
		 demandeur.get().setAdresse(newDemandeur.getAdresse());
		 demandeur.get().setNom(newDemandeur.getNom());
		 if(demandeurService.ajouterDemandeur(demandeur.get())!=null)
			 return new ResponseEntity<>(HttpStatus.OK);
		 return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);

	  }

	
	
}
