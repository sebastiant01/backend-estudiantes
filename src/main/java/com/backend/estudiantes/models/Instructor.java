package com.backend.estudiantes.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "instructores")
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instructor;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true)
    private String email = this.usuario.getEmail();

    @Column(nullable = false)
    private String especialidad;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion = LocalDate.now();


}
