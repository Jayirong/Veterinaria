package com.veterinaria.historial_clinico_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.historial_clinico_ms.model.HistorialClinico;
import java.util.List;


@Repository
public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long>{
    List<HistorialClinico> findByIdMascota(Long idMascota);
}
