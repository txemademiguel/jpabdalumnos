package com.fptxurdinaga.jpabdalumnos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fptxurdinaga.jpabdalumnos.domain.Alumno;
import com.fptxurdinaga.jpabdalumnos.repositories.AlumnoRepository;

import java.util.List;


@Controller
@RequestMapping(value = "/bdalumnos")
public class JpaBdalumnosController {
    Logger logger = LoggerFactory.getLogger(JpaBdalumnosController.class);
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @GetMapping()
    public String lista(Model modelo) {
        List<Alumno> alumnos = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "listado";
    }
}
