package com.example.controllers;

import com.example.dto.UserDTO;
import com.example.service.IKeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Controlador REST para gestionar usuarios en Keycloak.
 * Requiere que el usuario tenga el rol 'client_admin'.
 */
@RestController
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('client_admin')")
public class KeycloakController {

    @Autowired
    private IKeycloakService keycloakService;

    /**
     * Busca todos los usuarios.
     *
     * @return una lista de todos los usuarios
     */
    @GetMapping("/search")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario a buscar
     * @return el usuario encontrado
     */
    @GetMapping("/search/{username}")
    public ResponseEntity<?> searchUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param userDTO los datos del usuario a crear
     * @return la respuesta de la creación del usuario
     * @throws URISyntaxException si la URI es incorrecta
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        String response = keycloakService.createUser(userDTO);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param userId el ID del usuario a actualizar
     * @param userDTO los nuevos datos del usuario
     * @return un mensaje de éxito
     */
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO){
        keycloakService.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    /**
     * Elimina un usuario.
     *
     * @param userId el ID del usuario a eliminar
     * @return una respuesta sin contenido
     */
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        keycloakService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
