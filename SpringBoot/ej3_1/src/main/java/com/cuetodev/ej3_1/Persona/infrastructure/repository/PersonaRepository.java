package com.cuetodev.ej3_1.Persona.infrastructure.repository;

import com.cuetodev.ej3_1.errorhandling.NotFoundException;
import com.cuetodev.ej3_1.errorhandling.UnprocesableException;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Persona.infrastructure.repository.jpa.PersonaRepositoryJPA;
import com.cuetodev.ej3_1.Persona.infrastructure.repository.port.PersonaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaRepository implements PersonaRepositoryPort {

    @Autowired
    private PersonaRepositoryJPA personaRepositoryJPA;

    @Override
    public Persona save(Persona persona) {
        if (persona == null) return new Persona();
        personaRepositoryJPA.save(persona);
        return persona;
    }

    public Persona findPersonaById(int id) throws NotFoundException {
        return personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Id no encontrada"));
    }

    public List<Persona> findPersonaByUsuario(String usuario) throws Exception {
        return personaRepositoryJPA.findPersonaByUsuario(usuario);
    }

    public List<Persona> getAllPeople() throws Exception {
        return personaRepositoryJPA.getAllPeople();
    }

    @Override
    public int deletePerson(int id) throws Exception {
        try {
            return personaRepositoryJPA.deletePerson(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Persona updatePerson(Persona personaActualizada) throws UnprocesableException {
        Persona persona;
        try {
            persona = personaRepositoryJPA.save(personaActualizada);
        } catch (UnprocesableException e) {
            throw new UnprocesableException("Validación de campos no completada");
        }

        return persona;
    }
}
