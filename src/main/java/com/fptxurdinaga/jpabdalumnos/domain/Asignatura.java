package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Asignaturas")
@Table(name = "Asignaturas")
@Data
@ToString
public class Asignatura {
	private Long id;
    private String codasignatura;
    private String nombreasignatura;
    private String descripcion;
    
    private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
    
    public Asignatura(){
    	this.codasignatura ="PROG";
    	this.nombreasignatura = "Programacion";
    	this.descripcion = "Programacion en Java";
    }
    
    public Asignatura(String c, String n,String d){
    	this.codasignatura = c;
    	this.nombreasignatura = n;
    	this.descripcion = d;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	public String getCodasignatura() {
		return codasignatura;
	}
	public void setCodasignatura(String codasignatura) {
		this.codasignatura = codasignatura;
	}
	public String getNombreasignatura() {
		return nombreasignatura;
	}
	public void setNombreasignatura(String nombreasignatura) {
		this.nombreasignatura = nombreasignatura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
	@OneToMany(mappedBy = "asignatura")
	public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void addCalificaciones(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
    }
}
