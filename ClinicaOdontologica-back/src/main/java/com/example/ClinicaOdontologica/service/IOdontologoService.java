package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    List<Odontologo> findAllOdontologos();

    Optional<Odontologo> findOdontologoById(Long id) throws ResourceNotFoundException;

    Odontologo saveOdontologo(Odontologo odontologoNew) throws BadRequestException;

    void deleteOdontologo(Long id) throws ResourceNotFoundException;

    Odontologo updateOdontologo(Odontologo odontologoNew) throws BadRequestException;
}
