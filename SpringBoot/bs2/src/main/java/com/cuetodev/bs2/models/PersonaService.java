package com.cuetodev.bs2.models;

public interface PersonaService {
    String getNombre();
    void setNombre(String nombre);
    String getPoblacion();
    void setPoblacion(String poblacion);
    int getEdad();
    void setEdad(int edad);
    Persona getPersona();
}
