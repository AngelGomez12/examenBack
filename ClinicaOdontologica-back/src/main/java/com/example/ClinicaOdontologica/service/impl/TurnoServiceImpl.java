package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.Turno;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.example.ClinicaOdontologica.repository.ITurnoRepository;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import com.example.ClinicaOdontologica.service.IPacienteService;
import com.example.ClinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceImpl implements ITurnoService {

    private final static Logger log = Logger.getLogger(TurnoServiceImpl.class);

    private final ITurnoRepository turnoRepository;

    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper mapper;

    private boolean esNulo(Object objeto){
        return objeto == null;
    }

    private boolean validatePacienteOdontolgo(Long paciente_id, Long odontologo_id) throws ResourceNotFoundException {
        return pacienteService.findPacienteById(paciente_id).isPresent() &&
                odontologoService.findOdontologoById(odontologo_id).isPresent();
    }

    public TurnoServiceImpl(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Collection<TurnoDTO> findAllTurnos() {
       List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno t : turnos) {
            TurnoDTO turnoDTO = mapper.convertValue(t, TurnoDTO.class);
            turnosDTO.add(turnoDTO);
        }
        log.info("Exito, Turnos encontrados");
        return turnosDTO;
    }

    @Override
    public Optional<TurnoDTO> findTurnoById(Long id) throws ResourceNotFoundException, BadRequestException {
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
      try {
          if (turnoBuscado.isPresent()){
              TurnoDTO turnoDTO = mapper.convertValue(turnoBuscado.get(), TurnoDTO.class);
              log.info("Exito, turno encontrado");
              return Optional.of(turnoDTO);
          } else {
              log.error("Error, tuno no encontrado");
              throw new BadRequestException("El turno no existe");
          }
      } catch (IllegalArgumentException e){
          throw new ResourceNotFoundException("Ocurrio otro error que no encuentra el turno");
      }
    }

    @Override
    public Turno saveTurno(TurnoDTO turnoNew) throws ResourceNotFoundException, BadRequestException {
       try{
           Turno turno = mapper.convertValue(turnoNew, Turno.class);
           Paciente paciente = pacienteRepository.findById(turnoNew.getPacienteId())
                   .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
           Odontologo odontologo = odontologoRepository.findById(turnoNew.getOdontologoId())
                   .orElseThrow(() -> new ResourceNotFoundException("Odontólogo no encontrado"));
           turno.setPaciente(paciente);
           turno.setOdontologo(odontologo);
           Turno turnoGuardado = turnoRepository.save(turno);
           return turnoGuardado;
       } catch (IllegalArgumentException e) {
          throw new BadRequestException("No se puede crear el turno");
       }
    }

    @Override
    public void deleteTurno(Long id) throws ResourceNotFoundException, BadRequestException {
        Optional<TurnoDTO> turnoDelete = findTurnoById(id);
        if (turnoDelete.isPresent()){
            turnoRepository.deleteById(id);
            log.info("Exito, turno eliminado");
        } else {
            log.error("Error, el turno no existe");
            throw new ResourceNotFoundException("El turno no existe");
        }

    }

    @Override
    public TurnoDTO uptdateTurno(TurnoDTO turnoNew) throws ResourceNotFoundException, BadRequestException {
       if (!esNulo(turnoNew.getId()) && findTurnoById(turnoNew.getId()).isPresent()){
           if (validatePacienteOdontolgo(turnoNew.getPacienteId(), turnoNew.getOdontologoId())) {
               Turno turno = mapper.convertValue(turnoNew, Turno.class);
               Turno turnoActualizado = turnoRepository.save(turno);

               log.info("Turno actualizado");
               TurnoDTO turnoDTO = mapper.convertValue(turnoActualizado, TurnoDTO.class);
               return turnoDTO;
           } else {
               log.warn("Error, paciente o odontologo no encotrado");
               throw new BadRequestException("Paciente o odontologo no existen");
           }
       } else {
           log.warn("Error, tuno no existe");
           throw new ResourceNotFoundException("No se puede encontrar el turno");
       }
    }
}
