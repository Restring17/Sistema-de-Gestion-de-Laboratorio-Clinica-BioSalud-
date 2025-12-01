/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.service.impl;

import com.biosalud.lis.dao.interfaces.UsuarioDAO;
import com.biosalud.lis.dao.impl.UsuarioDAOImpl;
import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.service.interfaces.UsuarioService;
import com.biosalud.lis.util.HashUtil;
import java.util.List;

/**
 * Implementación del servicio de Usuario.
 */
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    /**
     * Constructor por defecto: crea un UsuarioDAOImpl internamente
     */
    public UsuarioServiceImpl() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    /**
     * Constructor que recibe un DAO (útil para tests / inyección).
     */
    public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }
        return usuarioDAO.buscarPorUsername(username);
    }

    @Override
    public boolean validarCredenciales(String username, String passwordPlain) {

        Usuario u = usuarioDAO.buscarPorUsername(username);

        if (u == null) {
            return false;
        }

        // Convertir la contraseña ingresada a SHA-256
        String hashIngresado = HashUtil.sha256(passwordPlain);

        // Comparar con el hash almacenado en la BD
        return hashIngresado.equals(u.getPasswordHash());
    }

    @Override
    public boolean registrarUsuario(Usuario usuario, String passwordPlain) {
        // Generar hash
        String hash = HashUtil.sha256(passwordPlain);
        usuario.setPasswordHash(hash);

        return usuarioDAO.insertar(usuario);
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioDAO.actualizar(usuario);
    }

    @Override
    public boolean eliminarPorUsuario(String usuario) {
        return usuarioDAO.eliminarPorUsuario(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    @Override
    public boolean cambiarPassword(String username, String newPasswordPlain) {
        if (username == null || username.trim().isEmpty() || newPasswordPlain == null || newPasswordPlain.isBlank()) {
            return false;
        }
        String hash = HashUtil.sha256(newPasswordPlain);
        return usuarioDAO.actualizarPasswordPorUsername(username, hash);
    }
}
