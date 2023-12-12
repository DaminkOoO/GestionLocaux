package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Facture;
import com.example.demo.entites.PlageHoraire;
import com.example.demo.entites.Reservation;
import com.example.demo.service.FactureService;
import com.example.demo.service.PlageHoraireService;
import com.example.demo.service.ReservationService;

@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
public class ReservationController {
	@Autowired
	private ReservationService reservationService; 
	@Autowired
	private FactureService factureService;
	@Autowired
	private PlageHoraireService plageHoraireService;
	@PostMapping("/reservation/save")
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
	    if (reservation.getFacture() != null && reservation.getFacture().getNum() == null) {

	        Facture savedFacture = factureService.ajouterFacture(reservation.getFacture());
	        // Set the saved Facture in the Reservation
	        reservation.setFacture(savedFacture);
	    }
	    if (reservation.getPlageHoraire() != null && reservation.getPlageHoraire().getId() == null) {
	    	PlageHoraire savedPlageHoraire= plageHoraireService.ajouterPlageHoraire(reservation.getPlageHoraire());
	    	reservation.setPlageHoraire(savedPlageHoraire);
	    }
        Reservation savedReservation = reservationService.saveOrUpdateReservation(reservation);
        return ResponseEntity.ok(savedReservation);
        
        
    }
	  // Delete reservation
	  @DeleteMapping("/{numReservation}")
	  public ResponseEntity<Void> deleteReservation(@PathVariable Long numReservation) {
	    Optional<Reservation> existingReservation = reservationService.getReservationById(numReservation);

	    if (existingReservation.isPresent()) {
	      reservationService.deleteReservationById(numReservation);
	      return ResponseEntity.noContent().build();
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }
	  @PutMapping("/{numReservation}")
	  public ResponseEntity<Reservation> updateReservation(
	      @PathVariable Long numReservation,
	      @RequestBody Reservation updatedReservation) {
	    Optional<Reservation> existingReservation = reservationService.getReservationById(numReservation);

	    if (existingReservation.isPresent()) {
	      Reservation reservationToUpdate = existingReservation.get();
	      // Set properties to update
	      // Example: reservationToUpdate.setDate(updatedReservation.getDate());
	      reservationService.saveOrUpdateReservation(reservationToUpdate);
	      return ResponseEntity.ok(reservationToUpdate);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }




}
