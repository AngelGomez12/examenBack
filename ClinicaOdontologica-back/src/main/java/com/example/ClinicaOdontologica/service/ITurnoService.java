package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.entity.Turno;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface ITurnoService {

    Collection<TurnoDTO> findAllTurnos();

    Optional<TurnoDTO> findTurnoById(Long id) throws ResourceNotFoundException, BadRequestException;

    Turno saveTurno(TurnoDTO turnoNew) throws ResourceNotFoundException, BadRequestException;

    void deleteTurno(Long id) throws ResourceNotFoundException, BadRequestException;

    TurnoDTO uptdateTurno(TurnoDTO turnoNew) throws ResourceNotFoundException,BadRequestException;
}
