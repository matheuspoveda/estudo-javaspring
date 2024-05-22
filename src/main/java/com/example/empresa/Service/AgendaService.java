package com.example.empresa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empresa.Entity.Agenda;
import com.example.empresa.Entity.Curso;
import com.example.empresa.Entity.Professor;
import com.example.empresa.Repository.AgendaRepository;
import com.example.empresa.Repository.CursoRepository;
import com.example.empresa.Repository.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Agenda saveAgenda(Agenda agenda) {
        Professor professor = professorRepository.findById(agenda.getProfessor().getId())
            .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com o ID fornecido"));
        Curso curso = cursoRepository.findById(agenda.getCurso().getId())
            .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o ID fornecido"));

        if (agendaRepository.existsByDataAndProfessor_Id(agenda.getData(), agenda.getProfessor().getId())) {
            throw new IllegalArgumentException("Professor já está ministrando um curso em outro local na mesma data");
        }

        agenda.setProfessor(professor);
        agenda.setCurso(curso);

        professor.getAgendas().add(agenda);
        curso.getAgendas().add(agenda);

        professorRepository.save(professor);
        cursoRepository.save(curso);

        return agendaRepository.save(agenda);
    }

    public List<Agenda> getAgendasByProfessor(Long professorId) {
        return agendaRepository.findByProfessor_IdWithDetails(professorId);
    }

    public Agenda updateResumo(Long id, String resumo) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada"));
        agenda.setResumo(resumo);
        return agendaRepository.save(agenda);
    }

    public Agenda findById(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada"));
    }

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }
}

