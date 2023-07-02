package com.example.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Domicilio")
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String calle;
    private String localidad;

    public Domicilio(int numero, String calle, String localidad, String provincia) {
        this.numero = numero;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    private String provincia;
}
