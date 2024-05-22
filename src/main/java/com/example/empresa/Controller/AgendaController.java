package com.example.empresa.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.Entity.Agenda;
import com.example.empresa.Service.AgendaService;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    @GetMapping("/professor/{professorId}")
    public List<Agenda> getAgendasByProfessor(@PathVariable Long professorId) {
        return agendaService.getAgendasByProfessor(professorId);
    }

    @PutMapping("/{id}/resumo")
    public Agenda updateResumo(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String resumo = requestBody.get("resumo");
        return agendaService.updateResumo(id, resumo);
    }

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.getAllAgendas();
    }
}


