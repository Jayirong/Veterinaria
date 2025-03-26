package com.veterinaria.empleados_ms.service;

import com.veterinaria.empleados_ms.model.Empleado;
import com.veterinaria.empleados_ms.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    
    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Optional<Empleado> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public List<Empleado> obtenerTodos(){
        return repository.findAll();
    }

    public Empleado crear(Empleado empleado){
        return repository.save(empleado);
    }

    public Optional<Empleado> actualizar(Long id, Empleado nuevoEmpleado) {
        return repository.findById(id).map(e -> {
            e.setNombre(nuevoEmpleado.getNombre());
            e.setCorreo(nuevoEmpleado.getCorreo());
            e.setCargo(nuevoEmpleado.getCargo());
            return repository.save(e);
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
