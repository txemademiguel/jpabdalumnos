package com.fptxurdinaga.jpabdalumnos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.jpabdalumnos.domain.Alumno;
import com.fptxurdinaga.jpabdalumnos.domain.Asignatura;
import com.fptxurdinaga.jpabdalumnos.domain.Calificacion;
import com.fptxurdinaga.jpabdalumnos.repositories.AlumnoRepository;
import com.fptxurdinaga.jpabdalumnos.repositories.AsignaturaRepository;
import com.fptxurdinaga.jpabdalumnos.repositories.CalificacionRepository;

import java.util.List;


@Controller
@RequestMapping(value = "/alumnos")
public class JpaBdalumnosController {
    Logger logger = LoggerFactory.getLogger(JpaBdalumnosController.class);
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AsignaturaRepository asignaturaRepository;
    @Autowired
    private CalificacionRepository calificacionRepository;
    
    @GetMapping()
    public String lista(Model modelo) {
        List<Alumno> alumnos = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "listado";
    }
    @GetMapping("/insertar")
    public String insertar(Model modelo) {
        Integer actualSize= alumnoRepository.findAll().size();
        if (actualSize.equals(0)){
        	// si no hay alumnos
        	// creo los alumnos
            Alumno a1 = new Alumno("1","N1","A1","1DW3");
            alumnoRepository.save(a1);
            Alumno a2 = new Alumno("2","N2","A2","2DW3");
            alumnoRepository.save(a2);
            Alumno a3 = new Alumno("3","N3","A3","2DW3");
            alumnoRepository.save(a3);
            Alumno a4 = new Alumno("4","N4","A4","1DW3");
            alumnoRepository.save(a4);
            // creo las asignaturas
            Asignatura as1 = new Asignatura("BD","Bases de Datos","Bases de Datos");
            asignaturaRepository.save(as1);
            Asignatura as2 = new Asignatura("ED","Entornos de Desarrollo","Entornos de Desarrollo");
            asignaturaRepository.save(as2);
            Asignatura as3 = new Asignatura("LM","Lenguajes de Marcas","Lenguajes de Marcas");
            asignaturaRepository.save(as3);
            Asignatura as4 = new Asignatura("PROG","Programacion","Programacion Java");
            asignaturaRepository.save(as4);
            // creo las calificaciones
            Calificacion c1 = new Calificacion();
            c1.setAlumno(a1);
            c1.setAsignatura(as1);
            c1.setNota(7);
            calificacionRepository.save(c1);
            Calificacion c2 = new Calificacion();
            c2.setAlumno(a1);
            c2.setAsignatura(as2);
            c2.setNota(9);
            calificacionRepository.save(c2);

            Calificacion c3 = new Calificacion();
            c3.setAlumno(a2);
            c3.setAsignatura(as4);
            c3.setNota(8);
            calificacionRepository.save(c3);
            // creo las calificaciones
            Calificacion c4 = new Calificacion();
            c4.setAlumno(a3);
            c4.setAsignatura(as1);
            c4.setNota(5);
            calificacionRepository.save(c4);
        }
        // cargo los datos de los alumnos en el modelo
        List<Alumno> listado = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", listado);
        // muestro el listado
        return "listado";
    }
    @GetMapping("/borrar")
    public String borrar(Model modelo) {
        Integer actualSize= alumnoRepository.findAll().size();
        if (actualSize > 0){
        	// si  hay alumnos
        	// borro las calificaciones
        	calificacionRepository.deleteAll();
        	// borro las asignaturas
            asignaturaRepository.deleteAll();
        	// borro los alumnos
            alumnoRepository.deleteAll();
        }
        // cargo los datos de los alumnos en el modelo
        List<Alumno> listado = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", listado);
        // muestro el listado
        return "listado";
    }
    @GetMapping("/listadoasignaturas")
    public String insertarasignatura(Model modelo) {
        Integer actualSize= asignaturaRepository.findAll().size();
        if (actualSize.equals(0)){
        	// si no hay asignaturas
            Asignatura a;
            a = new Asignatura("BD","Bases de Datos","Bases de Datos");
            asignaturaRepository.save(a);
            a = new Asignatura("ED","Entornos de Desarrollo","Entornos de Desarrollo");
            asignaturaRepository.save(a);
            a = new Asignatura("LM","Lenguajes de Marcas","Lenguajes de Marcas");
            asignaturaRepository.save(a);
            a = new Asignatura("PROG","Programacion","Programacion Java");
            asignaturaRepository.save(a);
        }
        // cargo los datos de las asignaturas en el modelo
        List<Asignatura> listadoasignaturas = asignaturaRepository.findAll();
        modelo.addAttribute("asignaturas", listadoasignaturas);
        // muestro el listado
        return "listadoasignaturas";
    }
}
