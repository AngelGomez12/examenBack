package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.repository.IDomicilioRepository;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.example.ClinicaOdontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Service
public class PacienteServiceImpl implements IPacienteService {

    @PersistenceContext
    private EntityManager entityManager;
    private final IPacienteRepository pacienteRepository;
    private final IDomicilioRepository domicilioRepository;

    public PacienteServiceImpl(EntityManager entityManager, IPacienteRepository pacienteRepository, IDomicilioRepository domicilioRepository) {
        this.entityManager = entityManager;
        this.pacienteRepository = pacienteRepository;
        this.domicilioRepository = domicilioRepository;
    }


    @Override
    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente savePaciente(Paciente pacienteNew) {
        Paciente savedPaciente = pacienteRepository.save(pacienteNew);
        if (pacienteNew.getDomicilio() != null) {
            pacienteNew.getDomicilio().setPaciente(savedPaciente);
            domicilioRepository.save(pacienteNew.getDomicilio());
        }
        return savedPaciente;
    }

    @Override
    public String deleletePaciente(Long id) {
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return "Paciente eliminado exitosamente";
        } else {
            return "No se encontro ningun paciente con el ID especificado";
        }

    }

    @Override
    public Paciente uptdatePaciente(Paciente pacienteNew) {
        return pacienteRepository.save(pacienteNew);
    }
}
