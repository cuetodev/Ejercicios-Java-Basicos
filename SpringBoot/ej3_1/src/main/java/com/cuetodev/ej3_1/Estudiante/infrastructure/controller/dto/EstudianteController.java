package com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto;

import com.cuetodev.ej3_1.Estudiante.application.port.EstudiantePort;
import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.input.EstudianteInputDTO;
import com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.output.EstudianteFullOutPutDTO;
import com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.output.EstudianteSimpleOutPutDTO;
import com.cuetodev.ej3_1.Persona.application.port.PersonaPort;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudiantePort estudiantePort;

    @PostMapping
    public ResponseEntity<?> insertEstudiante(@RequestBody EstudianteInputDTO estudianteInputDTO) throws Throwable {
        Estudiante estudianteRecibido;

        // Primero compruebo si la persona introducida está ya asignada a algún estudiante o profesor
        Optional<Estudiante> estudianteOptional = estudiantePort.findEstudianteByPersonID(estudianteInputDTO.getPersona());
        if (estudianteOptional.isPresent()) return new ResponseEntity<>("La persona introducida ya está asignada por otro estudiante", HttpStatus.BAD_REQUEST);

        Optional<Profesor> profesorOptional = estudiantePort.findProfesorByPersonID(estudianteInputDTO.getPersona());
        if (profesorOptional.isPresent()) return new ResponseEntity<>("La persona introducida ya está asignada por otro profesor", HttpStatus.BAD_REQUEST);

        try {
            estudianteRecibido = estudiantePort.insertEstudiante(estudianteInputDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(estudianteRecibido, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEstudianteByID(@PathVariable String id, @RequestParam(defaultValue = "simple", name = "outPutType") String outPutType) {

        try {
            // Primero busco el estudiante
            Estudiante estudiante = estudiantePort.findEstudianteById(id);

            // Dependiendo del outPutType devuelvo una respuesta con un OutPutDTO u otro
            if (outPutType.equals("simple")) return new ResponseEntity<>(new EstudianteSimpleOutPutDTO(estudiante), HttpStatus.OK);
            else if (outPutType.equals("full")) return new ResponseEntity<>(new EstudianteFullOutPutDTO(estudiante), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Petición incorrecta", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Petición incorrecta", HttpStatus.BAD_REQUEST);
    }

    @Autowired
    private PersonaPort personaPort;
}
