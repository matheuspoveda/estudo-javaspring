package com.example.empresa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.empresa.Entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("SELECT c FROM Curso c JOIN FETCH c.professores WHERE c.id = :id")
    Curso findByIdWithDetails(@Param("id") Long id);
}
