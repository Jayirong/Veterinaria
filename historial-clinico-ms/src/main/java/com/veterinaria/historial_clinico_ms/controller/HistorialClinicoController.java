package com.veterinaria.historial_clinico_ms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.historial_clinico_ms.model.HistorialClinico;
import com.veterinaria.historial_clinico_ms.service.HistorialClinicoService;

@RestController
@RequestMapping("/api/historial")
public class HistorialClinicoController {
    private final HistorialClinicoService service;

    public HistorialClinicoController(HistorialClinicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistorialClinico> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinico> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mascota/{idMascota}")
    public List<HistorialClinico> obtenerPorMascota(@PathVariable Long idMascota) {
        return service.obtenerPorMascota(idMascota);
    }

    @PostMapping
    public ResponseEntity<HistorialClinico> crear(@RequestBody HistorialClinico registro) {
        return ResponseEntity.ok(service.crear(registro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialClinico> actualizar(@PathVariable Long id, @RequestBody HistorialClinico registro) {
        return service.actualizar(id, registro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}