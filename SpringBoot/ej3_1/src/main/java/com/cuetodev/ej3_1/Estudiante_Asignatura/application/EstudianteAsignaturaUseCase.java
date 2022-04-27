package com.cuetodev.ej3_1.Estudiante_Asignatura.application;

import com.cuetodev.ej3_1.Asignatura.application.port.AsignaturaPort;
import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante.application.port.EstudiantePort;
import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante_Asignatura.application.port.EstudianteAsignaturaPort;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository.port.EstudianteAsignaturaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteAsignaturaUseCase implements EstudianteAsignaturaPort {

    @Autowired private EstudianteAsignaturaRepositoryPort estudianteAsignaturaRepositoryPort;
    @Autowired private EstudiantePort estudiantePort;
    @Autowired private AsignaturaPort asignaturaPort;

    @Override
    public EstudianteAsignatura addEstudianteAsignatura(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception {
        Estudiante estudiante = estudiantePort.findEstudianteById(estudianteAsignaturaInputDTO.getId_estudiante());
        Asignatura asignatura = asignaturaPort.findById(estudianteAsignaturaInputDTO.getId_asignatura());

        EstudianteAsignatura estudianteAsignatura = new EstudianteAsignatura();
        estudianteAsignatura.setAsignatura(asignatura);
        estudianteAsignatura.setEstudiante(estudiante);
        estudianteAsignatura.setFinish_date(estudianteAsignaturaInputDTO.getFinish_date());
        estudianteAsignatura.setInitial_date(estudianteAsignaturaInputDTO.getInitial_date());

        return estudianteAsignaturaRepositoryPort.addEstudianteAsignatura(estudianteAsignatura);
    }

    @Override
    public List<Asignatura> getAsignaturasByEstudianteID(String id_estudiante) {
        List<EstudianteAsignatura> estudianteAsignaturas = estudianteAsignaturaRepositoryPort.getAsignaturasByEstudianteID(id_estudiante);
        List<Asignatura> asignaturas = new ArrayList<>();
        estudianteAsignaturas.forEach(estudianteAsignatura -> asignaturas.add(estudianteAsignatura.getAsignatura()));

        return asignaturas;
    }

    @Override
    public List<String> addEstudianteAsignaturaByListOfIDS(String id_estudiante, List<String> asignaturasIDS) throws Exception {
        List<EstudianteAsignatura> estudianteAsignaturasList = new ArrayList<>();

        Estudiante estudiante = estudiantePort.findEstudianteById(id_estudiante);

        asignaturasIDS.forEach(asignaturaID -> {
            Asignatura asignatura = asignaturaPort.findById(asignaturaID);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                estudianteAsignaturasList.add(new EstudianteAsignatura(null, estudiante, asignatura, simpleDateFormat.parse(String.valueOf(LocalDateTime.now())), null));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });

        estudianteAsignaturaRepositoryPort.addEstudianteAsignaturaByListOfIDS(estudianteAsignaturasList);
        return null;
    }

    @Override
    public void deleteEstudianteAsignaturaByListOfIDS(String id_estudiante, List<String> asignaturasIDS) throws Exception {
        List<EstudianteAsignatura> estudianteAsignaturasList = new ArrayList<>();

        Estudiante estudiante = estudiantePort.findEstudianteById(id_estudiante);

        asignaturasIDS.forEach(asignaturaID -> {
            estudianteAsignaturasList.add(estudianteAsignaturaRepositoryPort.getEstudianteAsignaturaByAsignaturaID(asignaturaID, id_estudiante).get(0));
        });

        estudianteAsignaturaRepositoryPort.deleteEstudianteAsignaturaByListOfIDS(estudianteAsignaturasList);
    }
}
