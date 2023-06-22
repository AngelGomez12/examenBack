package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.service.IOdontologoService;
import com.example.ClinicaOdontologica.service.impl.DomicilioServiceImpl;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;
    @Autowired
    private IOdontologoService odontologoService;
    @Autowired
    private DomicilioServiceImpl domicilioService;


    @Transactional
    @GetMapping
    public List<Paciente> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:5173");

        return ResponseEntity.ok().headers(headers).body(pacientes).getBody();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id){
        return pacienteService.findPacienteById(id);
    }

    @PostMapping("/newPaciente")
    public Paciente createPaciente(@RequestBody Paciente newPaciente){
        Domicilio domicilio = newPaciente.getDomicilio();
        if (domicilio != null) {
            Domicilio savedDomicilio = domicilioService.saveDomicilio(domicilio);

            Paciente paciente = new Paciente();
            paciente.setName(newPaciente.getName());
            paciente.setLastName(newPaciente.getLastName());
            paciente.setEmail(newPaciente.getEmail());
            paciente.setDNI(newPaciente.getDNI());
            paciente.setFechaIngreso(newPaciente.getFechaIngreso());
            paciente.setDomicilio(savedDomicilio);

            Paciente savedPaciente = pacienteService.savePaciente(paciente);

            return savedPaciente;
        } else {
            throw new IllegalArgumentException("El domicilio del paciente no puede ser nulo");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deletePaciente(@PathVariable Long id){
        return pacienteService.deleletePaciente(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteNew){
        Optional<Paciente> existingPacienteOptional = pacienteService.findPacienteById(id);

        if (existingPacienteOptional.isPresent()){
            Paciente exisitstingPaciente = existingPacienteOptional.get();

            // Actualiza los atributos del paciente existente con los valores proporcionados
            exisitstingPaciente.setName(pacienteNew.getName());
            exisitstingPaciente.setLastName(pacienteNew.getLastName());
            exisitstingPaciente.setEmail(pacienteNew.getEmail());
            exisitstingPaciente.setDNI(pacienteNew.getDNI());
            exisitstingPaciente.setFechaIngreso(pacienteNew.getFechaIngreso());

            Paciente updatePaciente = pacienteService.savePaciente(exisitstingPaciente);

            return ResponseEntity.ok("Paciente actualizado con exito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
