package com.veterinaria.historial_clinico_ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.veterinaria.historial_clinico_ms.model.HistorialClinico;
import com.veterinaria.historial_clinico_ms.repository.HistorialClinicoRepository;

@Service
public class HistorialClinicoService {
    private final HistorialClinicoRepository repository;

    public HistorialClinicoService(HistorialClinicoRepository repository) {
        this.repository = repository;
    }

    public List<HistorialClinico> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<HistorialClinico> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<HistorialClinico> obtenerPorMascota(Long idMascota) {
        return repository.findByIdMascota(idMascota);
    }

    public HistorialClinico crear(HistorialClinico registro) {
        return repository.save(registro);
    }

    public Optional<HistorialClinico> actualizar(Long id, HistorialClinico nuevo) {
        return repository.findById(id).map(h -> {
            h.setFechaConsulta(nuevo.getFechaConsulta());
            h.setMotivo(nuevo.getMotivo());
            h.setDiagnostico(nuevo.getDiagnostico());
            h.setTratamiento(nuevo.getTratamiento());
            return repository.save(h);
        });
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}