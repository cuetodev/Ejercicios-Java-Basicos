package com.cuetodev.ej3_1.Persona.application.port;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface PersonaPort {
    public Persona insertPerson(Persona persona);
    public Persona findPersonaById(int id) throws Exception;
    public List<Persona> findPersonaByUsuario(String usuario) throws Exception;
    public List<Persona> getAllPeople() throws Exception;
    public int deletePerson(int id) throws Exception;
    public Persona updatePerson(Persona personaOriginal, PersonaInputDTO personaRecibida) throws Exception;
    public Optional<Estudiante> findEstudianteByPersonaID(Integer id_persona);
    public Optional<Profesor> findProfesorByPersonaID(Integer id_persona);
    public List<Persona> getData(HashMap<String, Object> conditions, String orderBy);
}
