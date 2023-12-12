package com.example.demo;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.IntToLongFunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entites.Demandeur;
import com.example.demo.entites.PlageHoraire;
import com.example.demo.entites.Reservation;
import com.example.demo.entites.Salle;
import com.example.demo.service.DemandeurService;
import com.example.demo.service.PlageHoraireService;
import com.example.demo.service.SalleService;

@SpringBootApplication
public class GestionLocauxApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GestionLocauxApplication.class, args);
		DemandeurService as = ctx.getBean(DemandeurService.class); 
		as.ajouterDemandeur(new Demandeur("Amin", "Route X"));
		as.ajouterDemandeur(new Demandeur("Amin", "Route X"));
		SalleService ss=ctx.getBean(SalleService.class); 
		ss.ajouterSalle(new Salle(200.0));
		ss.ajouterSalle(new Salle(400.0));
		ss.ajouterSalle(new Salle(100.0));
		PlageHoraireService ps = ctx.getBean(PlageHoraireService.class); 
		ps.ajouterPlageHoraire(new PlageHoraire(LocalDate.now(), 8, 10));
	}

}
