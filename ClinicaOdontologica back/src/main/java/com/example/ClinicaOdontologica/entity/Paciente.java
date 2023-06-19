package com.example.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;
    private String email;
    private LocalDate fechaIngreso;
    private Odontologo odontologo;

}
