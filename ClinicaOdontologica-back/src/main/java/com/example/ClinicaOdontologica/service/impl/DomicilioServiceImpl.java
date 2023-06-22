package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.repository.IDomicilioRepository;
import com.example.ClinicaOdontologica.service.IDomicilioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    private final IDomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> findAllDomicilios() {
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> findDomicilioById(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio saveDomicilio(Domicilio domicilioNew) {
        if (domicilioNew != null) {
            return domicilioRepository.save(domicilioNew);
        } else {
            throw new IllegalArgumentException("La entidad Domicilio no puede ser nula");
        }
    }

    @Override
    public String deleteDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        return "Domicilio eliminado con exito.";
    }

    @Override
    public Domicilio updateDomicilio(Domicilio domicilioNew) {
        return domicilioRepository.save(domicilioNew);
    }
}
