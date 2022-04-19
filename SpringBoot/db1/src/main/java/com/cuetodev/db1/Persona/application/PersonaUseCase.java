package com.cuetodev.db1.Persona.application;

import com.cuetodev.db1.Persona.application.port.PersonaPort;
import com.cuetodev.db1.Persona.domain.Persona;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.cuetodev.db1.Persona.infrastructure.repository.port.PersonaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PersonaUseCase implements PersonaPort {
    @Autowired
    private PersonaRepositoryPort personaRepositoryPort;

    @Override
    public Persona insertPerson(Persona persona) {
        // Llamo al save del repository
        personaRepositoryPort.save(persona);
        return persona;
    }

    @Override
    public Persona findPersonaById(int id) throws Exception {
        return personaRepositoryPort.findPersonaById(id);
    }

    @Override
    public List<Persona> findPersonaByUsuario(String usuario) throws Exception {
        return personaRepositoryPort.findPersonaByUsuario(usuario);
    }

    @Override
    public List<Persona> getAllPeople() throws Exception {
        return personaRepositoryPort.getAllPeople();
    }

    @Override
    public int deletePerson(int id) throws Exception {
        return personaRepositoryPort.deletePerson(id);
    }

    @Override
    public Persona updatePerson(Persona personaOriginal, PersonaInputDTO personaRecibida) throws Exception {
        Persona personaActualizada = new Persona();

        // Compruebo si algún dato me viene null y coloco en ese caso el de la persona original
        if (personaRecibida.getId() != null) personaActualizada.setId(personaRecibida.getId());
        else personaActualizada.setId(personaOriginal.getId());

        if (personaRecibida.getUsuario() != null) personaActualizada.setUsuario(personaRecibida.getUsuario());
        else personaActualizada.setUsuario(personaOriginal.getUsuario());

        if (personaRecibida.getPassword() != null) personaActualizada.setPassword(personaRecibida.getPassword());
        else personaActualizada.setPassword(personaOriginal.getPassword());

        if (personaRecibida.getName() != null) personaActualizada.setName(personaRecibida.getName());
        else personaActualizada.setName(personaOriginal.getName());

        if (personaRecibida.getSurname() != null) personaActualizada.setSurname(personaRecibida.getSurname());
        else personaActualizada.setSurname(personaOriginal.getSurname());

        if (personaRecibida.getCompany_email() != null) personaActualizada.setCompany_email(personaRecibida.getCompany_email());
        else personaActualizada.setCompany_email(personaOriginal.getCompany_email());

        if (personaRecibida.getPersona_email() != null) personaActualizada.setPersona_email(personaRecibida.getPersona_email());
        else personaActualizada.setPersona_email(personaOriginal.getPersona_email());

        if (personaRecibida.getCity() != null) personaActualizada.setCity(personaRecibida.getCity());
        else personaActualizada.setCity(personaOriginal.getCity());

        if (personaRecibida.getActive() != null) personaActualizada.setActive(personaRecibida.getActive());
        else personaActualizada.setActive(personaOriginal.getActive());

        if (personaRecibida.getCreated_date() != null) personaActualizada.setCreated_date(personaRecibida.getCreated_date().toString());
        else personaActualizada.setCreated_date(personaOriginal.getCreated_date());

        if (personaRecibida.getImagen_url() != null) personaActualizada.setImagen_url(personaRecibida.getImagen_url());
        else personaActualizada.setImagen_url(personaOriginal.getImagen_url());

        if (personaRecibida.getTermination_date() != null) personaActualizada.setTermination_date(personaRecibida.getTermination_date());
        else personaActualizada.setTermination_date(personaOriginal.getTermination_date());

        return personaRepositoryPort.updatePerson(personaActualizada);
    }
}
