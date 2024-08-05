package com.example.service;

import com.example.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

/**
 * Interfaz para el servicio de Keycloak.
 * Define los métodos para gestionar usuarios en Keycloak.
 */
public interface IKeycloakService {

    /**
     * Encuentra todos los usuarios.
     *
     * @return una lista de representaciones de usuarios
     */
    List<UserRepresentation> findAllUsers();

    /**
     * Busca usuarios por nombre de usuario.
     *
     * @param username el nombre de usuario a buscar
     * @return una lista de representaciones de usuarios que coinciden con el nombre de usuario
     */
    List<UserRepresentation> searchUserByUsername(String username);

    /**
     * Crea un nuevo usuario.
     *
     * @param userDTO los datos del usuario a crear
     * @return el ID del usuario creado
     */
    String createUser(UserDTO userDTO);

    /**
     * Elimina un usuario.
     *
     * @param userId el ID del usuario a eliminar
     */
    void deleteUser(String userId);

    /**
     * Actualiza un usuario existente.
     *
     * @param userId el ID del usuario a actualizar
     * @param userDTO los nuevos datos del usuario
     */
    void updateUser(String userId, UserDTO userDTO);
}