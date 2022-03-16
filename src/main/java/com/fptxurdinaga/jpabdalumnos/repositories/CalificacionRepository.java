package com.fptxurdinaga.jpabdalumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fptxurdinaga.jpabdalumnos.domain.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {
}
