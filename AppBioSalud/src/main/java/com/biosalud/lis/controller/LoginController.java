/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.controller;

import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.service.impl.UsuarioServiceImpl;
import com.biosalud.lis.service.interfaces.UsuarioService;

/**
 * Controlador encargado de coordinar la lógica de inicio de sesión.
 */
public class LoginController {

    private final UsuarioService usuarioService;

    /**
     * Constructor que recibe el servicio a utilizar.
     */
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public LoginController() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    /**
     * Inicia sesión validando el username y password.
     *
     * @param username el usuario ingresado
     * @param passwordPlain contraseña sin encriptar ingresada por el usuario
     * @return Usuario si coincide, null si no coincide
     */
    public Usuario iniciarSesion(String username, String passwordPlain) {

        // Paso 1: Buscar usuario
        Usuario u = usuarioService.buscarPorUsername(username);

        if (u == null) {
            return null; // Usuario no existe
        }

        // Paso 2: Validar contraseña usando el servicio
        boolean credencialesValidas = usuarioService.validarCredenciales(username, passwordPlain);

        if (!credencialesValidas) {
            return null; // Contraseña incorrecta
        }

        // Si todo OK
        return u;
    }
}
