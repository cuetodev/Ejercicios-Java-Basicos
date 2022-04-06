package com.cuetodev.bs2.controllers;

import com.cuetodev.bs2.config.BeanConfig;
import com.cuetodev.bs2.models.Ciudad;
import com.cuetodev.bs2.models.CiudadService;
import com.cuetodev.bs2.models.Persona;
import com.cuetodev.bs2.models.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/c2")
public class Controlador2 {
    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    @Autowired
    @Qualifier("bean1")
    Persona persona1;

    @Autowired
    @Qualifier("bean2")
    Persona persona2;

    @Autowired
    @Qualifier("bean3")
    Persona persona3;

    @GetMapping("/getPersona")
    public Persona getPersona() {
        personaService.setEdad(personaService.getEdad() + 1);
        return personaService.getPersona();
    }

    @GetMapping("/getCiudades")
    public List<Ciudad> getCiudades() {
        return ciudadService.getAllCiudades();
    }

    @GetMapping("/bean/{bean}")
    public Persona getBeanAndReturnPersona(@PathVariable String bean) {
        switch(bean) {
            case "bean1" -> {
                return persona1;
            }
            case "bean2" -> {
                return persona2;
            }
            case "bean3" -> {
                return persona3;
            }
            default -> {
                return new Persona();
            }
        }

    }
}
