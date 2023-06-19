package com.example.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "Paciente")
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("lastName")
    private String lastName;

    @Column
    @JsonProperty("DNI")
    private String DNI;

    @Column
    @JsonProperty("email")
    private String email;

    @Column
    @JsonProperty("fechaIngreso")
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    @JsonProperty("odontolgo")
    private Odontologo odontologo;

}
