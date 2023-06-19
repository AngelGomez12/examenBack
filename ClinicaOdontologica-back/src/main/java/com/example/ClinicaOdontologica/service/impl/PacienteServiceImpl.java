package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.example.ClinicaOdontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteServiceImpl implements IPacienteService {

    private final IPacienteRepository pacienteRepository;

    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
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
        if (pacienteNew != null) {
            return pacienteRepository.save(pacienteNew);
        }
        return new Paciente();
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
