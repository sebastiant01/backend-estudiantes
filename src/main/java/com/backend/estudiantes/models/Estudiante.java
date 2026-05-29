package com.backend.estudiantes.models;

import com.backend.estudiantes.models.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estudiantes")
@Data
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "codigo_estudiante", unique = true, nullable = false, length = 10)
    private String codigoEstudiante;

    @Column(name = "horas_acumuladas", nullable = false, columnDefinition = "integer default 0")
    private Integer horasAcumuladas;

    @Column(name = "programa_academico", nullable = false, length = 100)
    private String programaAcademico;

    @Column(nullable = false)
    private Integer semestre;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = false)
    private EstadoEstudiante estadoEstudiante = EstadoEstudiante.ACTIVO;

    public String getNombreCompleto() {
        return this.usuario.getNombre() + " " + this.usuario.getApellido();
    }
}
