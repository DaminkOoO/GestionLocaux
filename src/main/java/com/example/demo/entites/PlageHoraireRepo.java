package com.example.demo.entites;

import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PlageHoraireRepo extends JpaRepository<PlageHoraire,Long> {
	@Query("SELECT pl FROM PlageHoraire pl WHERE pl.date = :m ORDER BY pl.date DESC, pl.heureFin DESC")
    public Page<PlageHoraire> findLastDate(@Param("m") LocalDate date, Pageable pageable);
    List<PlageHoraire> findByDate(LocalDate date);
}
	

