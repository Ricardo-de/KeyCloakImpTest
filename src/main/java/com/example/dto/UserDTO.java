package com.example.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Clase DTO para representar un usuario.
 * Implementa Serializable para permitir la serialización del objeto.
 */
@Value
@RequiredArgsConstructor
@Builder
public class UserDTO implements Serializable {

    /**
     * Nombre de usuario.
     */
    private String username;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Nombre del usuario.
     */
    private String firstName;

    /**
     * Apellido del usuario.
     */
    private String lastName;

    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Conjunto de roles asignados al usuario.
     */
    private Set<String> roles;
}
