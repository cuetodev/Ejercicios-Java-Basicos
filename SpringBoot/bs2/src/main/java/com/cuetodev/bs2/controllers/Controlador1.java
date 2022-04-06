package com.cuetodev.bs2.controllers;

import com.cuetodev.bs2.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c1")
public class Controlador1 {
    @Autowired
    PersonaService personaService;
    @Autowired
    CiudadService ciudadService;

    @PostMapping("/addPersona")
    public Persona postPersona(@RequestBody Persona persona) {
        personaService.setNombre(persona.getName());
        personaService.setPoblacion(persona.getPopulation());
        personaService.setEdad(persona.getAge());

        return personaService.getPersona();
    }

    @PostMapping("/addCiudad")
    public String postCiudad(@RequestBody Ciudad ciudad) {
        ciudadService.addCiudad(ciudad);

        return "Ciudad insertada correctamente";
    }
}
