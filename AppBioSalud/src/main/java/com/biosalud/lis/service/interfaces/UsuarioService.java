/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biosalud.lis.service.interfaces;

import com.biosalud.lis.model.Usuario;

/**
 * Servicio para operaciones sobre Usuario
 */
public interface UsuarioService {
    Usuario buscarPorUsername(String username);
    /**
     * Valida las credenciales planas (password en texto) contra la contraseña guardada (hash)
     * @return true si coincide
     */
    boolean validarCredenciales(String username, String passwordPlain);
    boolean registrarUsuario(Usuario usuario, String passwordPlain);
}

