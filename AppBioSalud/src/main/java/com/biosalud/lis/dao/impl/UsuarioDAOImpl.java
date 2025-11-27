/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.UsuarioDAO;
import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.persistence.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario buscarPorUsername(String username) {

        String sql = "SELECT * FROM usuario WHERE username=?";
        Usuario u = null;

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPasswordHash(rs.getString("password_hash"));
                u.setRol(rs.getString("rol"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }


    @Override
    public boolean insertar(Usuario usuario) {

        String sql = "INSERT INTO usuario (username, password_hash, rol) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPasswordHash());
            ps.setString(3, usuario.getRol());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

