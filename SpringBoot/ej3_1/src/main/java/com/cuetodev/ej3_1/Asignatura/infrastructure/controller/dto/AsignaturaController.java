package com.cuetodev.ej3_1.Asignatura.infrastructure.controller.dto;

import com.cuetodev.ej3_1.Asignatura.application.port.AsignaturaPort;
import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    AsignaturaPort asignaturaPort;

    @PostMapping("/add")
    public ResponseEntity<?> addAsignatura(@RequestBody AsignaturaInputDTO asignaturaInputDTO) {
        Asignatura asignatura;
        try {
            asignatura = asignaturaPort.addAsignatura(asignaturaInputDTO.convertDTOEntity());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(asignatura, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Asignatura getAsignatura(@PathVariable String id_asignatura) {
        return asignaturaPort.findById(id_asignatura);
    }
}
