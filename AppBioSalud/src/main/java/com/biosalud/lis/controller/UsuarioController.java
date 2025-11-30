/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.controller;

import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.service.impl.UsuarioServiceImpl;
import com.biosalud.lis.service.interfaces.UsuarioService;

import java.util.List;

public class UsuarioController {

    private final UsuarioService usuarioService = new UsuarioServiceImpl();

    public boolean registrar(Usuario u, String passwordPlain) {
        return usuarioService.registrarUsuario(u, passwordPlain);
    }

    public boolean actualizar(Usuario u) {
        return usuarioService.actualizarUsuario(u);
    }

    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    public Usuario buscar(String username) {
        return usuarioService.buscarPorUsername(username);
    }

    public boolean eliminarPorUsuario(String usuario) {
        return usuarioService.eliminarPorUsuario(usuario);
    }

    public boolean cambiarPassword(String username, String newPasswordPlain) {
        return usuarioService.cambiarPassword(username, newPasswordPlain);
    }
}
