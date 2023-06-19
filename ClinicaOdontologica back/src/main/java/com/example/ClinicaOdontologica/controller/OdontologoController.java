package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Odontologo;
import com.example.ClinicaOdontologica.service.impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class OdontologoController {

  @Autowired
  private OdontologoServiceImpl odontologoService;

    @GetMapping
    public List<Odontologo> getAllOdontologos(){
        List<Odontologo> odontologos = odontologoService.findAllOdontologos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:5173"); // Reemplaza con el dominio de tu aplicación cliente

        return ResponseEntity.ok().headers(headers).body(odontologos).getBody();
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> getOdontologoById(@PathVariable Long id){
        return odontologoService.findOdontologoById(id);
    }

    @PostMapping("/newOdontologo")
    public Odontologo createOdontolgo(@RequestBody Odontologo newOdontolgo){
        Odontologo odontologo = new Odontologo();
        odontologo.setId(newOdontolgo.getId());
        odontologo.setName(newOdontolgo.getName());
        odontologo.setLastName(newOdontolgo.getLastName());
        odontologo.setMatricula(newOdontolgo.getMatricula());

        Odontologo savedOdontologo = odontologoService.saveOdontologo(odontologo);

        return ResponseEntity.ok(savedOdontologo).getBody();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOdontologo(@PathVariable Long id){
        return odontologoService.deleteOdontologo(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOdontologo(@PathVariable Long id, @RequestBody Odontologo odontologoNew) {
        Optional<Odontologo> existingOdontologoOptional = odontologoService.findOdontologoById(id);

        if (existingOdontologoOptional.isPresent()) {
            Odontologo existingOdontologo = existingOdontologoOptional.get();

            // Actualiza los atributos del odontólogo existente con los valores proporcionados
            existingOdontologo.setName(odontologoNew.getName());
            existingOdontologo.setLastName(odontologoNew.getLastName());
            existingOdontologo.setMatricula(odontologoNew.getMatricula());

            Odontologo updatedOdontologo = odontologoService.saveOdontologo(existingOdontologo);

            return ResponseEntity.ok("Odontólogo actualizado con éxito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
