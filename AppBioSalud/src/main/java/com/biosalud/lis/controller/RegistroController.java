/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.controller;

import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.service.interfaces.UsuarioService;
import com.biosalud.lis.service.impl.UsuarioServiceImpl;

public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    public boolean registrar(Usuario usuario, String passwordPlain) {

        // Verificar si ya existe usuario
        if (usuarioService.buscarPorUsername(usuario.getUsername()) != null) {
            return false; // usuario duplicado
        }

        // Registrar en BD con hash
        return usuarioService.registrarUsuario(usuario, passwordPlain);
    }
}
