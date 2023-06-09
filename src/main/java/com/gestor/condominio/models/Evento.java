package com.gestor.condominio.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dono;
    private String tipo;
    @ElementCollection
    private List<String> membros;

    private String data;
    private double orcamento;

    @ElementCollection
    private List<String> recursos;

    @ElementCollection
    private List<String> regrasRegulamentos;
}
