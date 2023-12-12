package com.example.demo.controllers;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entites.Salle;
import com.example.demo.service.SalleService;
@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
public class SalleController {
	@Autowired
	private SalleService salleService;
	@GetMapping("/salle")
	public List<Salle> getSalles() {
	    return salleService.getListSalle();
	}
	
	 @PostMapping("/salle")
	    public ResponseEntity<Salle> addSalle(@RequestBody Salle nouvelleSalle) {
	        Salle salleAjoutee = salleService.ajouterSalle(nouvelleSalle);
	        return new ResponseEntity<>(salleAjoutee, HttpStatus.CREATED);
	    }

	
	
	@GetMapping("/salle/{id}")
	public Optional<Salle> getSalle(@PathVariable Long id){
		return salleService.getSalle(id);
	}
	@DeleteMapping("/salle/{id}")
	public ResponseEntity<?> deleteSalle(@PathVariable Long id) {

		if(salleService.supprimerSalleID(id)) {
	        return new ResponseEntity<>(HttpStatus.OK);

		}else
	        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);

	}
	 @PutMapping("/salle/{id}")
	public ResponseEntity<?> replaceEmployee(@RequestBody Salle newSalle, @PathVariable Long id) {
		 Optional<Salle> salle= salleService.getSalle(id);
		 salle.get().setSuperficie(newSalle.getSuperficie());
		 if(salleService.ajouterSalle(salle.get())!=null)
			 return new ResponseEntity<>(HttpStatus.OK);
		 return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);

	  }
	 @GetMapping("/salle/free/{date}/{heureDebut}/{heureFin}")
	    public List<Salle> getFreeSalles(
	    		@PathVariable("date") LocalDate date,
	    		@PathVariable("heureDebut") int heureDebut,
	    		@PathVariable("heureFin") int heureFin) {
		 	System.out.println(date.toString());
	        List<Salle> freeSalles = salleService.getFreeSalle(date, heureDebut, heureFin);

	        // You can perform additional processing or return the result directly based on your requirements.
	        return freeSalles;
	    }
	
	
}
