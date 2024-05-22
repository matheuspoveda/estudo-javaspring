package com.example.empresa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa.Entity.Curso;
import com.example.empresa.Repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}