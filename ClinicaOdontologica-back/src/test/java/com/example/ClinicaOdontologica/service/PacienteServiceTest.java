package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Domicilio;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPaciente() throws BadRequestException {
        Paciente pacienteParaGuardar = new Paciente("Gomez","Angel","Gomez","gomez@gmail.com",LocalDate.parse("2023-03-29"),
                new Domicilio(143,"4567","Canelones","Montevideo"));

        Paciente pacienteGuardado = pacienteService.savePaciente(pacienteParaGuardar);
        assertTrue(pacienteGuardado.getDNI() == "45678945");
    }

    @Test
    @Order(2)
    public void actualizarPaciente() throws ResourceNotFoundException, BadRequestException {
        Optional<Paciente> pacienteParaActualizar = pacienteService.findPacienteById(1L);
        pacienteParaActualizar.get().setName("Angel");
        pacienteParaActualizar.get().getDomicilio().setCalle("Colon");

        Paciente pacienteActualizado = pacienteService.savePaciente(pacienteParaActualizar.get());

        assertEquals("Angel", pacienteActualizado.getName());
        assertEquals("Colon", pacienteActualizado.getDomicilio().getCalle());
    }

    @Test
    @Order(3)
    public void buscarPacientePorId() throws ResourceNotFoundException {
        Optional<Paciente> pacienteEncontrado = pacienteService.findPacienteById(1L);

        assertNotNull(pacienteEncontrado);
        assertEquals("Angel", pacienteEncontrado.get().getName());
    }


    @Test
    @Order(5)
    public void buscarPacientes() {
        Collection<Paciente> pacientesGuardados = pacienteService.findAllPacientes();

        assertTrue(1 == pacientesGuardados.size());
    }

    @Test
    @Order(6)
    public void eliminarPaciente() throws ResourceNotFoundException {
        pacienteService.deleletePaciente(1L);
        Collection<Paciente> pacientes = pacienteService.findAllPacientes();
        assertTrue(pacientes.size() == 0);
    }
}
