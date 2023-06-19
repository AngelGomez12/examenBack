package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    List<Odontologo> findAllOdontologos();

    Optional<Odontologo> findOdontologoById(Long id);

    Odontologo saveOdontologo(Odontologo odontologoNew);

    String deleteOdontologo(Long id);

    Odontologo updateOdontologo(Odontologo odontologoNew);
}
