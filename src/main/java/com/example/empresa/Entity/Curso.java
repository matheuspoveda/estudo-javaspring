package com.example.empresa.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String cargaHoraria;
    private String objetivos;
    private String ementa;

    @ManyToMany
    @JoinTable(
        name = "curso_professor",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professores;

    @OneToMany(mappedBy = "curso")
    private List<Agenda> agendas;
}