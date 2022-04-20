package com.cuetodev.db1.Persona.infrastructure.controller;

import com.cuetodev.db1.Persona.application.errorhandling.NotFoundException;
import com.cuetodev.db1.Persona.application.errorhandling.UnprocesableException;
import com.cuetodev.db1.Persona.application.port.PersonaPort;
import com.cuetodev.db1.Persona.domain.Persona;
import com.cuetodev.db1.Persona.domain.PersonaList;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaPort personaPort;

    /*
    --------------
        INSERT
    --------------
    */

    @PostMapping
    public ResponseEntity<?> insertPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        // Cambio mi InputDTO a la entidad Persona
        Persona persona = personaInputDTO.convertInputDtoToEntity();
        Persona personaRecibida;

        try {
            personaRecibida = personaPort.insertPerson(persona);
        } catch (Exception e) {
            throw new UnprocesableException("Validación de campos errónea");
        }

        // Llamo al insert que tengo en la clase del caso de uso del application
        // este método accederá al del repositorio que se encargará de realizar la consulta
        return new ResponseEntity<>(personaRecibida, HttpStatus.OK);
    }

    /*
    ------------------
        GET / FIND
    ------------------
    */

    @GetMapping("/{id}")
    public ResponseEntity<?> findPersonaById(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO;
        try {
            personaOutputDTO = new PersonaOutputDTO(personaPort.findPersonaById(id));
        } catch (Exception e) {
            throw new NotFoundException("Persona con ID: " + id + ", no encontrada.");
        }
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    /*
        La idea en los siguientes métodos es devolver la lista preparada para una paginación real
        de tal forma que tengo un objeto nuevo que es el que voy a devolver (PersonaList)
        este objeto contiene una lista de personas(PersonaOutPutDTO), además del Nº total
        de elementos de la lista.
    */

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<?> findPersonaByUsuario(@PathVariable String usuario) throws Exception {
        List<PersonaOutputDTO> peopleOutPutDTO = new ArrayList<>();
        PersonaList personaList;
        try {
            // Recorro la lista de personas para transformarla a la lista de personasOutPutDTO
            personaPort.findPersonaByUsuario(usuario).forEach(persona -> {
                try {
                    peopleOutPutDTO.add(new PersonaOutputDTO(persona));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            // Creo el objeto después de rellenar la lista para obtener el número de elementos totales
            // desde el constructor del objeto.
            personaList = new PersonaList(peopleOutPutDTO);
        } catch (Exception e) {
            return new ResponseEntity<>("Persona con usuario: " + usuario + ", no encontrada.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaList, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPeople() throws Exception {
        List<PersonaOutputDTO> peopleOutPutDTO = new ArrayList<>();
        PersonaList personaList;
        try {
            // Recorro la lista de personas para transformarla a la lista de personasOutPutDTO
            personaPort.getAllPeople().forEach(persona -> {
                try {
                    peopleOutPutDTO.add(new PersonaOutputDTO(persona));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            // Creo el objeto después de rellenar la lista para obtener el número de elementos totales
            // desde el constructor del objeto.
            personaList = new PersonaList(peopleOutPutDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaList, HttpStatus.OK);
    }

    /*
    --------------
        DELETE
    --------------
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable int id) throws Exception {
        int numberOfResults = -1;

        try {
            numberOfResults = personaPort.deletePerson(id);
        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido borrar a la persona", HttpStatus.BAD_REQUEST);
        }

        if (numberOfResults != 1) {
            throw new NotFoundException("Persona con ID: " + id + ", no encontrada.");
        }

        return new ResponseEntity<>("Persona borrada correctamente", HttpStatus.OK);
    }

    /*
    --------------
        UPDATE
    --------------
    */

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonById(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        try {
            Persona personaOriginal = personaPort.findPersonaById(id);
            personaPort.updatePerson(personaOriginal, personaInputDTO);
        } catch (Exception e) {
            throw new UnprocesableException("Validación de campos errónea");
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
