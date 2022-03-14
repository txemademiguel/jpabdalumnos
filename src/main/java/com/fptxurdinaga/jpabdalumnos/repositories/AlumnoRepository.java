package com.fptxurdinaga.jpabdalumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fptxurdinaga.jpabdalumnos.domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
