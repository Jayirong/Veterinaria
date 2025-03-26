package com.veterinaria.empleados_ms.repository;

import com.veterinaria.empleados_ms.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
}
