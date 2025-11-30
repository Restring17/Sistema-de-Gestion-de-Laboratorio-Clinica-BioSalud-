package com.biosalud.lis.dao.impl;
import com.biosalud.lis.persistence.DBConnection;
import com.biosalud.lis.dao.interfaces.MedicoDAO;
import com.biosalud.lis.model.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAOImpl implements MedicoDAO {

    private Connection getConnection() throws SQLException {
        return DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean insertar(Medico medico) {
        String sql = "{CALL sp_medico_insertar(?,?,?,?,?)}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, medico.getNombres());
            cs.setString(2, medico.getApellidos());
            cs.setString(3, medico.getEspecialidad());
            cs.setString(4, medico.getCmp());
            cs.setString(5, medico.getTelefono());

            int resultado = cs.executeUpdate(); 
            return resultado > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar médico: " + e.getMessage());
            return false;
        }
    }

   @Override
    public boolean actualizar(Medico medico) {
        String sql = "{CALL sp_medico_actualizar(?,?,?,?,?,?)}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, medico.getIdMedico());
            cs.setString(2, medico.getNombres());
            cs.setString(3, medico.getApellidos());
            cs.setString(4, medico.getEspecialidad());
            cs.setString(5, medico.getCmp());
            cs.setString(6, medico.getTelefono());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar médico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idMedico) {
        String sql = "{CALL sp_medico_eliminar(?)}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idMedico);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar médico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Medico buscarPorId(int idMedico) {
        String sql = "{CALL sp_medico_obtenerPorID(?)}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idMedico);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return new Medico(
                        rs.getInt("id_medico"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("especialidad"),
                        rs.getString("cmp"),
                        rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar médico por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medico> listarTodos() {
        List<Medico> lista = new ArrayList<>();
        String sql = "{CALL sp_medico_listar()}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("id_medico"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("especialidad"),
                        rs.getString("cmp"),
                        rs.getString("telefono")
                );
                lista.add(medico);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar médicos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public int contarMedicos() {
        String sql = "{CALL sp_medico_contar(?)}";
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            return cs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Error al contar médicos: " + e.getMessage());
            return 0;
        }
    }
}