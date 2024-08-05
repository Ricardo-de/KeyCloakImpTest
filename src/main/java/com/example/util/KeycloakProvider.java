package com.example.util;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

/**
 * Proveedor de Keycloak para obtener recursos del realm y usuarios.
 */
public class KeycloakProvider {

    private static final String SERVER_URL = "http://localhost:9445";
    private static final String REALM_NAME = "SECURE_IT";
    private static final String REALM_MASTER = "Keycloak";
    private static final String ADMIN_CLI = "admin-cli";
    private static final String USER_CONSOLE = "admin";
    private static final String PASSWORD_CONSOLE = "keycloak";
    private static final String CLIENT_SECRET = "9uMIl808V3r9cYeGt36d4pOrFvZmn7dP";

    /**
     * Obtiene el recurso del realm de Keycloak.
     *
     * @return el recurso del reino
     */
    public static RealmResource getRealmResource() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(SERVER_URL)
                .realm(REALM_MASTER)
                .clientId(ADMIN_CLI)
                .username(USER_CONSOLE)
                .password(PASSWORD_CONSOLE)
                .clientSecret(CLIENT_SECRET)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .connectionPoolSize(10)
                        .build())
                .build();

        return keycloak.realm(REALM_NAME);
    }

    /**
     * Obtiene el recurso de usuarios del realm de Keycloak.
     *
     * @return el recurso de usuarios
     */
    public static UsersResource getUserResource() {
        RealmResource realmResource = getRealmResource();
        return realmResource.users();
    }
}
