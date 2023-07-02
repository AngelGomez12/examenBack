package com.example.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Odontologo")
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {

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
    @JsonProperty("matricula")
    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Turno> turnos;

    public Odontologo(String name, String lastName, String matricula) {
        this.name = name;
        this.lastName = lastName;
        this.matricula = matricula;
    }
}
