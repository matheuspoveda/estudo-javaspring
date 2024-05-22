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

import com.example.empresa.Entity.Curso;
import com.example.empresa.Service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
}