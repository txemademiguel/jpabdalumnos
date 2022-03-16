package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "Alumnos")
@Table(name = "Alumnos")
@Data
public class Alumno {
    @Id
    private String dni;
    private String nombre;
    private String apellidos;
    private String grupo;
    
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
}
