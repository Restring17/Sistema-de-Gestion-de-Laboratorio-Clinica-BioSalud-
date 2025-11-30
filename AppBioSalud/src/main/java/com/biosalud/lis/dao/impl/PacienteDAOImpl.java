/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.PacienteDAO;
import com.biosalud.lis.model.Paciente;
import com.biosalud.lis.persistence.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author folli
 */
public class PacienteDAOImpl implements PacienteDAO {

    @Override
    public boolean insertar(Paciente paciente) {
        String sql = "{CALL sp_insertar_paciente(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, paciente.getDni());
            stmt.setString(2, paciente.getNombres());
            stmt.setString(3, paciente.getApellidos());
            stmt.setDate(4, paciente.getFechaNacimiento() != null ? 
                Date.valueOf(paciente.getFechaNacimiento()) : null);
            stmt.setString(5, paciente.getTelefono());
            stmt.setString(6, paciente.getEmail());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        String sql = "{CALL sp_actualizar_paciente(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setInt(1, paciente.getIdPaciente());
            stmt.setString(2, paciente.getDni());
            stmt.setString(3, paciente.getNombres());
            stmt.setString(4, paciente.getApellidos());
            stmt.setDate(5, paciente.getFechaNacimiento() != null ? 
                Date.valueOf(paciente.getFechaNacimiento()) : null);
            stmt.setString(6, paciente.getTelefono());
            stmt.setString(7, paciente.getEmail());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer idPaciente) {
        String sql = "{CALL sp_eliminar_paciente(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setInt(1, idPaciente);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Paciente buscarPorId(Integer idPaciente) {
        String sql = "{CALL sp_buscar_paciente_por_id(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearPaciente(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Paciente buscarPorDni(String dni) {
        String sql = "{CALL sp_buscar_paciente_por_dni(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapearPaciente(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Paciente> buscarPorApellidos(String apellidos) {
        String sql = "{CALL sp_buscar_paciente_por_apellidos(?)}";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            stmt.setString(1, "%" + apellidos + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                pacientes.add(mapearPaciente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> listarTodos() {
        String sql = "{CALL sp_listar_pacientes()}";
        List<Paciente> pacientes = new ArrayList<>();
        
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                pacientes.add(mapearPaciente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public int contarPacientes() {
        String sql = "{CALL sp_contar_pacientes()}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Paciente mapearPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(rs.getInt("id_paciente"));
        paciente.setDni(rs.getString("dni"));
        paciente.setNombres(rs.getString("nombres"));
        paciente.setApellidos(rs.getString("apellidos"));
        
        Date fecha = rs.getDate("fecha_nacimiento");
        if (fecha != null) {
            paciente.setFechaNacimiento(fecha.toLocalDate());
        }
        
        paciente.setTelefono(rs.getString("telefono"));
        paciente.setEmail(rs.getString("email"));
        
        return paciente;
    }
}
