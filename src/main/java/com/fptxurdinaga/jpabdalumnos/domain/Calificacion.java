package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Calificaciones")
@Table(name = "Calificaciones")
@Data
public class Calificacion {
    @Id
    private String dni;
    private String codasignatura;
    private Integer nota;
    
    public Calificacion(){
		super();
		this.dni="00000000A";
		this.codasignatura = "PROG";
		this.nota = 5;
	}
    public Calificacion(String d,String c,Integer n){
		super();
		this.dni=d;
		this.codasignatura = c;
		this.nota = n;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodasignatura() {
		return codasignatura;
	}
	public void setCodasignatura(String codasignatura) {
		this.codasignatura = codasignatura;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
}
