package com.example.demo.service;

import com.example.demo.entites.Reservation;
import com.example.demo.entites.ReservationRepo;

import jakarta.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepository;

    @Autowired
    public ReservationService(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Create or update a reservation
    @Transient
    public Reservation saveOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Retrieve a reservation by its ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Delete a reservation by its ID
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    // Calculate the price of the reservation
    

    // Cancel a reservation
    public boolean cancelReservation(Reservation reservation) {
        if (!reservation.getEtat().equals("confirmer")) {
            reservation.setEtat("Annulé");
            return true;
        }
        return false;
    }

    // Confirm a reservation
    public boolean confirmReservation(Reservation reservation) {
        if (!reservation.getEtat().equals("Annulé")) {
            reservation.setEtat("confirmer");
            return true;
        }
        return false;
    }
}
