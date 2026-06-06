package com.backend.estudiantes.repositories;

import com.backend.estudiantes.models.Usuario;
import com.backend.estudiantes.models.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository repository;

    @Test
    void findByEmail_UsuarioExistente_ReturnUsuario() {
        Usuario usuarioTest = new Usuario(
                "test",
                "user",
                "test@uni.co.co",
                "12345",
                Role.ESTUDIANTE
        );
        Usuario usuarioGuardado = this.repository.save(usuarioTest);

        Optional<Usuario> usuarioEncontrado = this.repository.findByEmail(usuarioGuardado.getEmail());

        assertTrue(usuarioEncontrado.isPresent(), "El usuario debería existir en la base de datos.");

        Usuario encontrado = usuarioEncontrado.get();

        assertEquals("test@uni.co.co", encontrado.getEmail(),
                "El e-mail del usuario encontrado debería coincidir con el de prueba.");
    }
}
