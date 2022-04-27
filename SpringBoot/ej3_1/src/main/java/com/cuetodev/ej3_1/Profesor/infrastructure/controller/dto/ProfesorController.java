package com.cuetodev.ej3_1.Profesor.infrastructure.controller.dto;

import com.cuetodev.ej3_1.Persona.application.port.PersonaPort;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Profesor.application.port.ProfesorPort;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import com.cuetodev.ej3_1.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.cuetodev.ej3_1.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.cuetodev.ej3_1.errorhandling.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorPort profesorPort;

    /*@PostMapping
    public ResponseEntity<?> insertProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) {

        Profesor profesor = getPersonaByIDAndReturnProfesor(profesorInputDTO);
        Profesor profesorRecibido;

        try {
            profesorRecibido = profesorPort.insertProfesor(profesor);
        } catch (UnprocesableException e) {
            throw new UnprocesableException("Validación de campos errónea");
        }

        return new ResponseEntity<>(profesorRecibido, HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<?> findProfesorByID(@PathVariable String id, @RequestParam(defaultValue = "simple", name = "outPutType") String outPutType) {

        try {
            // Primero busco el profesor
            Profesor profesor = profesorPort.findProfesorById(id);

            // Dependiendo del outPutType devuelvo una respuesta con un OutPutDTO u otro
            if (outPutType.equals("simple")) return new ResponseEntity<>(new ProfesorOutputDTO(profesor), HttpStatus.OK);
            else if (outPutType.equals("full")) return new ResponseEntity<>(new ProfesorOutputDTO(profesor), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Petición incorrecta", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Petición incorrecta", HttpStatus.BAD_REQUEST);
    }

    @Autowired
    private PersonaPort personaPort;

   /* public Profesor getPersonaByIDAndReturnProfesor(ProfesorInputDTO profesorInputDTO) {
        Profesor profesor;
        Persona persona;

        try {
            persona = personaPort.findPersonaById(profesorInputDTO.getId_persona());
        } catch (Exception e) {

        }

        return profesor;
    }*/

}
