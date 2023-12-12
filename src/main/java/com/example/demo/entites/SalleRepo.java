package com.example.demo.entites;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SalleRepo extends JpaRepository<Salle, Long> {
	@Query("SELECT DISTINCT s FROM Salle s LEFT JOIN s.reservations r WHERE r.plageHoraire.date = :date AND r.plageHoraire.heureDebut = :heureDebut AND r.plageHoraire.heureFin = :heureFin")
    List<Salle> findFreeSalles(@Param("date") LocalDate date, @Param("heureDebut") int heureDebut, @Param("heureFin") int heureFin);

}
