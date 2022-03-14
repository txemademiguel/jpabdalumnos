package com.fptxurdinaga.jpabdalumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fptxurdinaga.jpabdalumnos.domain.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Long> {
}
