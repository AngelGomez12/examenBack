package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {

    List<Domicilio> findAllDomicilios();

    Optional<Domicilio> findDomicilioById(Long id);

    Domicilio saveDomicilio(Domicilio domicilioNew);

    String deleteDomicilio(Long id);

    Domicilio updateDomicilio(Domicilio domicilioNew);
}
