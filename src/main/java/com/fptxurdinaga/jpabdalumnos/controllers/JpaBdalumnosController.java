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
            Alumno a;
            a = new Alumno("1","N1","A1","1DW3");
            alumnoRepository.save(a);
            a = new Alumno("2","N2","A2","2DW3");
            alumnoRepository.save(a);
            a = new Alumno("3","N3","A3","2DW3");
            alumnoRepository.save(a);
            a = new Alumno("4","N4","A4","1DW3");
            alumnoRepository.save(a);
            // guardo los cambios en la base de datos
            alumnoRepository.flush();
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
        	// borro todos
            alumnoRepository.deleteAll();
            // guardo los cambios en la base de datos
            alumnoRepository.flush();
        }
        // cargo los datos de los alumnos en el modelo
        List<Alumno> listado = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", listado);
        // muestro el listado
        return "listado";
    }
    @GetMapping("/insertarasignaturas")
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
            // guardo los cambios en la base de datos
            asignaturaRepository.flush();
        }
        // cargo los datos de las asignaturas en el modelo
        List<Asignatura> listadoasignaturas = asignaturaRepository.findAll();
        modelo.addAttribute("asignaturas", listadoasignaturas);
        // muestro el listado
        return "listadoasignaturas";
    }
    @GetMapping("/borrarasignaturas")
    public String borrarasignaturas(Model modelo) {
        Integer actualSize= asignaturaRepository.findAll().size();
        if (actualSize > 0){
        	// si  hay asignaturas
        	// borro todas
        	asignaturaRepository.deleteAll();
            // guardo los cambios en la base de datos
        	asignaturaRepository.flush();
        }
        // cargo los datos de las asignaturas en el modelo
        List<Asignatura> listadoasignaturas = asignaturaRepository.findAll();
        modelo.addAttribute("asignaturas", listadoasignaturas);
        // muestro el listado
        return "listadoasignaturas";
    }
    @GetMapping("/insertarcalificaciones")
    public String insertarcalificaciones(Model modelo) {
        Integer actualSize= calificacionRepository.findAll().size();
        if (actualSize.equals(0)){
        	// si no hay calificaciones
            Calificacion c;
            c = new Calificacion("1","BD",7);
            calificacionRepository.save(c);
            c = new Calificacion("1","PROG",9);
            calificacionRepository.save(c);
            c = new Calificacion("2","PROG",6);
            calificacionRepository.save(c);
            c = new Calificacion("3","LM",5);
            calificacionRepository.save(c);
            c = new Calificacion("3","PROG",4);
            calificacionRepository.save(c);
            c = new Calificacion("4","ED",9);
            calificacionRepository.save(c);
            // guardo los cambios en la base de datos
            calificacionRepository.flush();
        }
        // cargo los datos de las asignaturas en el modelo
        List<Calificacion> listadocalificaciones = calificacionRepository.findAll();
        modelo.addAttribute("calificaciones", listadocalificaciones);
        // muestro el listado
        return "listadocalificaciones";
    }
    @GetMapping("/borrarcalificaciones")
    public String borrarcalificaciones(Model modelo) {
        Integer actualSize= calificacionRepository.findAll().size();
        if (actualSize > 0){
        	// si  hay calificaciones
        	// borro todas
        	calificacionRepository.deleteAll();
            // guardo los cambios en la base de datos
        	calificacionRepository.flush();
        }
        // cargo los datos de las asignaturas en el modelo
        List<Calificacion> listadocalificaciones = calificacionRepository.findAll();
        modelo.addAttribute("calificaciones", listadocalificaciones);
        // muestro el listado
        return "listadocalificaciones";
    }
}
