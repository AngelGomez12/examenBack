package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    List<Turno> findAllTurnos();

    Optional<Turno> findTurnoById(Long id);

    Turno saveTurno(Turno turnoNew);

    String deleleteTurno(Long id);

    Turno uptdateTurno(Turno turnoNew);
}
