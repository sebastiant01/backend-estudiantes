package com.backend.estudiantes.models;

import com.backend.estudiantes.models.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "estudiantes")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "codigo_estudiante", unique = true, nullable = false, length = 10)
    private String codigoEstudiante;

    @Column(name = "horas_acumuladas", nullable = false)
    private Integer horasAcumuladas = 0;

    @Column(name = "programa_academico", nullable = false, length = 100)
    private String programaAcademico;

    @Column(nullable = false)
    private Integer semestre;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = false)
    private EstadoEstudiante estadoEstudiante = EstadoEstudiante.ACTIVO;

    @CreatedDate
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public Estudiante() {
    }

    public Estudiante(Usuario usuario,
                      String codigoEstudiante,
                      String programaAcademico,
                      Integer semestre,
                      EstadoEstudiante estadoEstudiante) {
        this.usuario = usuario;
        this.codigoEstudiante = codigoEstudiante;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.estadoEstudiante = estadoEstudiante;
    }

    public String getNombreCompleto() {
        return this.usuario.getNombre() + " " + this.usuario.getApellido();
    }
}
