package com.example.empresa.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.empresa.Entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Query("SELECT a FROM Agenda a JOIN FETCH a.professor JOIN FETCH a.curso WHERE a.professor.id = :professorId")
    List<Agenda> findByProfessor_IdWithDetails(@Param("professorId") Long professorId);
    
    boolean existsByDataAndProfessor_Id(LocalDateTime data, Long professorId);
    List<Agenda> findByProfessor_Id(Long professorId);
}