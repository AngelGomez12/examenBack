package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologo() throws BadRequestException {
        Odontologo odontologoParaGuardar = new Odontologo("Angel","Gomez","123");

        Odontologo odontologoGuardado = odontologoService.saveOdontologo(odontologoParaGuardar);
        assertEquals(odontologoGuardado.getMatricula(),"123");
    }

    @Test
    @Order(2)
    public void actualizarOdontologo() throws BadRequestException, ResourceNotFoundException {
        Optional<Odontologo> odontologoParaActualizar = odontologoService.findOdontologoById(1L);
        odontologoParaActualizar.get().setName("Walter");
        odontologoParaActualizar.get().setLastName("Benegas");

        Odontologo odontologoActualizado = odontologoService.updateOdontologo(odontologoParaActualizar.get());

        assertEquals("Walter", odontologoActualizado.getName());
        assertEquals("Benegas", odontologoActualizado.getLastName());
    }

    @Test
    @Order(3)
    public void buscarOdontologoPorId() throws ResourceNotFoundException {
        Optional<Odontologo> odontologoEncontrado = odontologoService.findOdontologoById(1L);

        assertEquals("Benegas", odontologoEncontrado.get().getLastName());
    }

    @Test
    @Order(4)
    public void buscarOdontologos() {
        Collection<Odontologo> odontologosGuardados = odontologoService.findAllOdontologos();

        assertTrue(1 == odontologosGuardados.size());
    }

    @Test
    @Order(5)
    public void eliminarOdontologo() throws ResourceNotFoundException {
        odontologoService.deleteOdontologo(1L);
        Collection<Odontologo> odontologos = odontologoService.findAllOdontologos();
        assertTrue(odontologos.size() == 0);
    }
}
