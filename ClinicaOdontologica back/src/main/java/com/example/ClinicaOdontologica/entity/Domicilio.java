package com.example.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio {

    private Long id;
    private int numero;
    private String calle;
    private String localidad;
    private String provincia;
}
