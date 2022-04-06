package com.cuetodev.bs2.controllers;

import com.cuetodev.bs2.config.BeanConfig;
import com.cuetodev.bs2.models.Ciudad;
import com.cuetodev.bs2.models.CiudadService;
import com.cuetodev.bs2.models.Persona;
import com.cuetodev.bs2.models.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Persona persona;
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        if (bean.equals("bean1")) {
            persona = ctx.getBean("bean1", Persona.class);
            return persona;
        } else if (bean.equals("bean2")) {
            persona = ctx.getBean("bean2", Persona.class);
            return persona;
        }
        persona = ctx.getBean("bean3", Persona.class);
        return persona;
    }
}
