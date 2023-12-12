package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.PlageHoraire;
import com.example.demo.entites.PlageHoraireRepo;
import com.example.demo.service.DemandeurService;

@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
public class PlageHoraireController {
	@Autowired
	private PlageHoraireRepo plageHoraireRepo;
	@GetMapping("/plageHoraire/freePlageHoraire/{date}")
	public int getLastFin(@PathVariable LocalDate date) {
		List<PlageHoraire> lesPlagesHoraires = plageHoraireRepo.findByDate(date);
		System.out.println(lesPlagesHoraires);
		if(lesPlagesHoraires.size()==0)
			return -1;
		return lesPlagesHoraires.get(lesPlagesHoraires.size()-1).getHeureFin();
	}
}
