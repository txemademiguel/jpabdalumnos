package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Calificaciones")
@Table(name = "Calificaciones")
@Data
@ToString
public class Calificacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dni")
    private Alumno alumno;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codasignatura")
    private Asignatura asignatura;
    
	private int nota;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
}
