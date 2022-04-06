package com.cuetodev.bs2.models;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImplemented implements PersonaService {

    Persona persona = new Persona();

    @Override
    public String getNombre() {
        return persona.getName();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setName(nombre);
    }

    @Override
    public String getPoblacion() {
        return persona.getPopulation();
    }

    @Override
    public void setPoblacion(String poblacion) {
        persona.setPopulation(poblacion);
    }

    @Override
    public int getEdad() {
        return persona.getAge();
    }

    @Override
    public void setEdad(int edad) {
        persona.setAge(edad);
    }

    @Override
    public Persona getPersona() {
        return this.persona;
    }
}
