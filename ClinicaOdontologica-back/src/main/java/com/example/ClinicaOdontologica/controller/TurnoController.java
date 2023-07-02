package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.DTO.TurnoDTO;
import com.example.ClinicaOdontologica.exceptions.BadRequestException;
import com.example.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController  {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping("/saveTurno")
    public ResponseEntity<?> saveTurno(@RequestBody TurnoDTO turnoNew) throws BadRequestException, ResourceNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.saveTurno(turnoNew));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTurno(@RequestBody TurnoDTO turnoNew) throws BadRequestException, ResourceNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.uptdateTurno(turnoNew));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id) throws BadRequestException, ResourceNotFoundException{
        turnoService.deleteTurno(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.findTurnoById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAllTurnos(){
        Collection<TurnoDTO> turnos = turnoService.findAllTurnos();
        if (turnos.size() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(turnos);
        else return ResponseEntity.status(HttpStatus.OK).body(turnos);
    }
}
