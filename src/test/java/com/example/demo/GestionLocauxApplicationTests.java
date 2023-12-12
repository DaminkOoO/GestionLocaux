package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.entites.*;

class GestionLocauxApplicationTests {

    private Reservation reservation;

    @BeforeEach
    void setUp() {
        Facture facture = new Facture();
        Salle salle = new Salle();
        PlageHoraire plageHoraire = new PlageHoraire(); 
        Demandeur demandeur = new Demandeur();

        reservation = new Reservation(facture, salle, plageHoraire, demandeur, "confirmer");
    }

    @Test
    void testCalculPrixLocationPetiteSalle() {

        reservation.getSalle().setSuperficie(150);
        reservation.getPlageHoraire().setHeureDebut(8);
        reservation.getPlageHoraire().setHeureFin(18);

        double prixAttendu = 700.0; 
        double prixCalculé = reservation.CalculPrixLocation();

        assertEquals(prixAttendu, prixCalculé, "Le prix de location pour une petite salle n'est pas correct.");
    }

    @Test
    void testCalculPrixLocationGrandeSalle() {
        reservation.getSalle().setSuperficie(250);
        reservation.getPlageHoraire().setHeureDebut(8);
        reservation.getPlageHoraire().setHeureFin(18);

        double prixAttendu = 1300; 
        double prixCalculé = reservation.CalculPrixLocation();

        assertEquals(prixAttendu, prixCalculé, "Le prix de location pour une grande salle n'est pas correct.");
    }

}