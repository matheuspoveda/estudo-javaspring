package com.example.empresa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.Entity.Professor;
import com.example.empresa.Service.ProfessorService;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/curso/{cursoId}")
    public List<Professor> getProfessoresByCurso(@PathVariable Long cursoId) {
        return professorService.getProfessoresByCurso(cursoId);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}