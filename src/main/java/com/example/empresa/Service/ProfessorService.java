package com.example.empresa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa.Entity.Professor;
import com.example.empresa.Repository.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getProfessoresByCurso(Long cursoId) {
        return professorRepository.findByCursos_Id(cursoId);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}