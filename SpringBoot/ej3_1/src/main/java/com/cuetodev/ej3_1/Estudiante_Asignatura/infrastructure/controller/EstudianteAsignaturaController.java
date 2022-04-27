package com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.controller;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante.application.port.EstudiantePort;
import com.cuetodev.ej3_1.Estudiante_Asignatura.application.port.EstudianteAsignaturaPort;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante_asignatura")
public class EstudianteAsignaturaController {

    @Autowired private EstudianteAsignaturaPort estudianteAsignaturaPort;
    @Autowired private EstudiantePort estudiantePort;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAsignaturasByEstudianteID(@PathVariable String id) {

        List<Asignatura> asignaturaList;
        asignaturaList = estudianteAsignaturaPort.getAsignaturasByEstudianteID(id);

        return new ResponseEntity<>(asignaturaList, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> addEstudianteAsignatura(@RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception {
        return new ResponseEntity<>(estudianteAsignaturaPort.addEstudianteAsignatura(estudianteAsignaturaInputDTO), HttpStatus.OK);
    }

    @PostMapping("/addByIDS/{id}")
    public ResponseEntity<?> addEstudianteAsignaturaByListOfIDS(@PathVariable(value = "id") String id_estudiante, @RequestBody List<String> asignaturasIDS) throws Exception {
        return new ResponseEntity<>(estudianteAsignaturaPort.addEstudianteAsignaturaByListOfIDS(id_estudiante, asignaturasIDS), HttpStatus.OK);
    }

    @DeleteMapping("/deleteByIDS/{id}")
    public ResponseEntity<?> deleteEstudianteAsignaturaByListOfIDS(@PathVariable(value = "id") String id_estudiante, @RequestBody List<String> asignaturasIDS) throws Exception {
        estudianteAsignaturaPort.deleteEstudianteAsignaturaByListOfIDS(id_estudiante, asignaturasIDS);
        return new ResponseEntity<>("Asignaturas eliminadas correctamente del usuario", HttpStatus.OK);
    }

}
