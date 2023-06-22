package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.service.impl.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
@CrossOrigin(origins = "http://localhost:8080")
public class DomicilioController {

    @Autowired
    private DomicilioServiceImpl domicilioService;

    @PostMapping
    public Domicilio saveDomicilio(@RequestBody Domicilio domicilio) {

        Domicilio domicilio1 = new Domicilio();
        domicilio1.setCalle(domicilio.getCalle());
        domicilio1.setLocalidad(domicilio.getLocalidad());
        domicilio1.setNumero(domicilio.getNumero());
        domicilio1.setProvincia(domicilio.getProvincia());
        domicilio1.setPaciente(domicilio.getPaciente());

        Domicilio savedDomicilio = domicilioService.saveDomicilio(domicilio1);

        return savedDomicilio;
    }
}
