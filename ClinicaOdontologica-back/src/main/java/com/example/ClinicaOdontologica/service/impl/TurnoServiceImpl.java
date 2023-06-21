package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Turno;
import com.example.ClinicaOdontologica.repository.ITurnoRepository;
import com.example.ClinicaOdontologica.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoService {

    private final ITurnoRepository turnoRepository;

    public TurnoServiceImpl(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> findAllTurnos() {
        return null;
    }

    @Override
    public Optional<Turno> findTurnoById(Long id) {
        return Optional.empty();
    }

    @Override
    public Turno saveTurno(Turno turnoNew) {
        return null;
    }

    @Override
    public String deleleteTurno(Long id) {
        return null;
    }

    @Override
    public Turno uptdateTurno(Turno turnoNew) {
        return null;
    }
}
