/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.UsuarioDAO;
import com.biosalud.lis.model.Usuario;
import com.biosalud.lis.persistence.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE username=?";
        Usuario u = null;

        try (Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = mapUsuario(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean insertar(Usuario usuario) {
        String sql = "{CALL sp_insert_usuario(?,?,?,?,?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, usuario.getUsername());
            cs.setString(2, usuario.getPasswordHash());
            cs.setString(3, usuario.getRol());
            cs.setString(4, usuario.getNombre());
            cs.setString(5, usuario.getEmail());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        String sql = "{CALL sp_update_usuario(?,?,?,?,?,?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, usuario.getIdUsuario());
            cs.setString(2, usuario.getUsername());
            cs.setString(3, usuario.getRol());
            cs.setString(4, usuario.getNombre());
            cs.setString(5, usuario.getEmail());
            cs.setString(6, usuario.getEstado());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarPorUsuario(String username) {
        String sql = "{CALL sp_eliminar_usuario(?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, username);
            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY id_usuario";

        try (Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapUsuario(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    private Usuario mapUsuario(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("id_usuario"));
        u.setUsername(rs.getString("username"));
        u.setPasswordHash(rs.getString("password_hash"));
        u.setRol(rs.getString("rol"));
        u.setNombre(rs.getString("nombre"));
        u.setEmail(rs.getString("email"));
        u.setEstado(rs.getString("estado"));
        return u;
    }
}
