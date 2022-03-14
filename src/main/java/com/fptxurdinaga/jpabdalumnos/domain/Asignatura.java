package com.fptxurdinaga.jpabdalumnos.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Asignaturas")
@Table(name = "Asignaturas")
@Data
public class Asignatura {
    @Id
    private String codasignatura;
    private String nombreasignatura;
    private String descripcion;
    
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
    
    
    
}
