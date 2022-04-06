package com.cuetodev.bs2.config;

import com.cuetodev.bs2.models.Persona;
import com.cuetodev.bs2.models.PersonaService;
import com.cuetodev.bs2.models.PersonaServiceImplemented;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("bean1")
    public Persona getPersona1() {
        PersonaService personaService = new PersonaServiceImplemented();
        personaService.setNombre("bean1");
        personaService.setEdad(5);
        return personaService.getPersona();
    }

    @Bean("bean2")
    public Persona getPersona2() {
        PersonaService personaService = new PersonaServiceImplemented();
        personaService.setNombre("bean2");
        personaService.setEdad(25);
        return personaService.getPersona();
    }

    @Bean("bean3")
    public Persona getPersona3() {
        PersonaService personaService = new PersonaServiceImplemented();
        personaService.setNombre("bean3");
        personaService.setEdad(35);
        return personaService.getPersona();
    }
}
