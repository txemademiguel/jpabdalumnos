package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Alumnos")
@Table(name = "Alumnos")
@Data
@ToString
public class Alumno {
	private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String grupo;
    
    private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
    
    public Alumno(){
		super();
		// propiedades de Alumno
		this.dni="00000000A";
		this.nombre = "Anonimo";
		this.apellidos = "";
		this.grupo = "1DW3";
	}
    public Alumno(String d,String n,String a,String g){
		super();
		// propiedades de Alumno
		this.dni=d;
		this.nombre = n;
		this.apellidos = a;
		this.grupo = g;
	}
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	@OneToMany(mappedBy = "alumno")
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
