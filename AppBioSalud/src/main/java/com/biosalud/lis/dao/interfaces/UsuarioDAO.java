/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.Usuario;

/**
 *
 * @author folli
 */
public interface UsuarioDAO {
    Usuario buscarPorUsername(String username);
    boolean insertar(Usuario usuario);
}
