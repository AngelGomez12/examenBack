package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<Paciente> findAllPacientes();

    Optional<Paciente> findPacienteById(Long id);

    Paciente savePaciente(Paciente pacienteNew);

    String deleletePaciente(Long id);

    Paciente uptdatePaciente(Paciente pacienteNew);
}
