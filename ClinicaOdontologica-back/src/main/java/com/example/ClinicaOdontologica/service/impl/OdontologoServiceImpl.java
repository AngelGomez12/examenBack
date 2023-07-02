package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    private final static Logger log = Logger.getLogger(OdontologoServiceImpl.class);

    private final IOdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public List<Odontologo> findAllOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findOdontologoById(Long id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(id);
        if (odontologoBuscado.isPresent()){
            log.info("Odontolgo encontrado");
            return odontologoRepository.findById(id);
        } else {
            log.error("Error, no se encutra al odntolgo");
            throw new ResourceNotFoundException("El odontologo no existe");
        }
    }

    @Override
    public Odontologo saveOdontologo(Odontologo odontologoNew) throws BadRequestException {
        if (odontologoNew != null){
            log.info("Odontologo creado con exito");
            return odontologoRepository.save(odontologoNew);
        } else {
            log.error("No se puedo crear el Odontolgo");
            throw new BadRequestException("Le faltan datos al odontologo");
        }
    }


    @Override
    public void deleteOdontologo(Long id) throws ResourceNotFoundException {
        if (odontologoRepository.existsById(id)) {
            log.info("Odontólogo eliminado exitosamente.");
            odontologoRepository.deleteById(id);
        } else {
            log.error("Error, no se encuentra el odontolgo");
            throw new ResourceNotFoundException("El odontolgo no existe");
        }
    }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologoNew) throws BadRequestException{
        if (odontologoNew != null) {
            log.info("Odontolgo actualizado con exito");
            return odontologoRepository.save(odontologoNew);
        } else {
            log.error("No se pudo encontrar el odontologo");
            throw new BadRequestException("No se puede actualizar el odontolgo");
        }
    }
}
