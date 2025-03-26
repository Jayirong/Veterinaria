package com.veterinaria.historial_clinico_ms.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HISTORIAL_CLINICO")
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idMascota;

    @Column(nullable = false)
    private LocalDate fechaConsulta;

    @Column(nullable = false)
    private String motivo;

    private String diagnostico;
    private String tratamiento;
}