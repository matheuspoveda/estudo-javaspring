package com.example.empresa.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.empresa.Entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByCursos_Id(Long cursoId);

    @Query("SELECT p FROM Professor p JOIN FETCH p.cursos WHERE p.id = :id")
    Professor findByIdWithDetails(@Param("id") Long id);
}
