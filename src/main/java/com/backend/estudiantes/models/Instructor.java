package com.backend.estudiantes.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "instructores")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor")
    private Long idInstructor;

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String especialidad;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion = LocalDate.now();

    @CreatedDate
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public Instructor() {
    }

    public Instructor(Usuario usuario, String especialidad) {
        this.usuario = usuario;
        this.especialidad = especialidad;
    }
}
