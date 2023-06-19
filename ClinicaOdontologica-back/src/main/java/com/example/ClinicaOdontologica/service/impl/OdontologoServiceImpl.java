package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    private final IOdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public List<Odontologo> findAllOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findOdontologoById(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo saveOdontologo(Odontologo odontologoNew) {
        if (odontologoNew != null){
            return odontologoRepository.save(odontologoNew);
        }
        return new Odontologo();
    }


    @Override
    public String deleteOdontologo(Long id) {
        if (odontologoRepository.existsById(id)) {
            odontologoRepository.deleteById(id);
            return "Odontólogo eliminado exitosamente.";
        } else {
            return "No se encontró ningún odontólogo con el ID especificado.";
        }
    }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologoNew) {
        return odontologoRepository.save(odontologoNew);
    }
}
