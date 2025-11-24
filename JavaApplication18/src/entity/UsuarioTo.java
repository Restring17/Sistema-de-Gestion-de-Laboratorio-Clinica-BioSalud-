/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 * Transfer Object (TO) para Usuario del sistema.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Transporta los datos de usuario entre capas.
 *  - SRP: Representa únicamente la información del usuario (sin lógica).
 *  - OCP: Puede ampliarse sin modificar otras capas.
 *  - PROTOTYPE: Útil si se generan copias temporales del usuario (sesiones, permisos).
 *  - STRATEGY (aplicable externamente): Para aplicar diferentes estrategias de autenticación.
 */
public class UsuarioTo {

    // Atributos
    private int idUsuario;
    private String username;
    private String password;
    private String rol;        // Administrador / Técnico / Recepción
    private String estado;     // Activo / Inactivo

    // Constructor vacío
    public UsuarioTo() {
    }

    // Constructor completo
    public UsuarioTo(int idUsuario, String username, String password,
                     String rol, String estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

