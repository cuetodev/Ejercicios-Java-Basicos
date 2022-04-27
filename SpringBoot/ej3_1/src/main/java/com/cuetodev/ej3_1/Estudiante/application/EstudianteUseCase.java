package com.cuetodev.ej3_1.Estudiante.application;

import com.cuetodev.ej3_1.Estudiante.application.port.EstudiantePort;
import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.input.EstudianteInputDTO;
import com.cuetodev.ej3_1.Estudiante.infrastructure.repository.port.EstudianteRepositoryPort;
import com.cuetodev.ej3_1.Persona.application.port.PersonaPort;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Profesor.application.port.ProfesorPort;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteUseCase implements EstudiantePort {
    @Autowired private EstudianteRepositoryPort estudianteRepositoryPort;
    @Autowired private PersonaPort personaPort;
    @Autowired private ProfesorPort profesorPort;

    @Override
    public Estudiante insertEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception {
        Persona persona = getPersonaByID(estudianteInputDTO.getPersona());
        Estudiante estudiante = convertDTOEntity(estudianteInputDTO, persona);
        // Llamo al save del repository
        estudianteRepositoryPort.save(estudiante);
        return estudiante;
    }

    @Override
    public Optional<Estudiante> findEstudianteByPersonID(Integer id_persona) {
        return estudianteRepositoryPort.findEstudianteByPersonaID(id_persona);
    }

    @Override
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona) {
        return profesorPort.findProfesorByPersonID(id_persona);
    }

    @Override
    public Estudiante findEstudianteById(String id) throws Exception {
        return estudianteRepositoryPort.findEstudianteById(id);
    }

    public Persona getPersonaByID(int id_persona) throws Exception {
        Persona persona;

        try {
            persona = personaPort.findPersonaById(id_persona);
        } catch (Exception e) {
            throw new Exception("No se ha podido encontrar a la Persona con ID: " + id_persona);
        }

        return persona;
    }

    public Estudiante convertDTOEntity(EstudianteInputDTO estudianteInputDTO, Persona persona) {
        return new Estudiante(estudianteInputDTO.getId_estudiante(), persona, null, estudianteInputDTO.getComments(), estudianteInputDTO.getNum_hours_week(), estudianteInputDTO.getBranch(), estudianteInputDTO.getAsignaturas());
    }

}
