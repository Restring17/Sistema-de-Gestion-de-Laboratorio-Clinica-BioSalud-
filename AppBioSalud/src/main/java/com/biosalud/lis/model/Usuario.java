/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.model;

public class Usuario {
    private int id_usuario;
    private String username;
    private String password_hash;
    private String rol;

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return password_hash;
    }

    public void setPasswordHash(String passwordHash) {
        this.password_hash = passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

