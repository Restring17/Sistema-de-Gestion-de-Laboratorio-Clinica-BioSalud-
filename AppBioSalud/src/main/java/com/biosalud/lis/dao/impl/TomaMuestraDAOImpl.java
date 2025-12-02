package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.TomaMuestraDAO;
import com.biosalud.lis.model.TomaMuestra;
import com.biosalud.lis.persistence.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TomaMuestraDAOImpl implements TomaMuestraDAO {


    @Override
    public boolean registrar(TomaMuestra m) {
        String sql = "{CALL sp_registrar_muestra(?, ?, ?, ?, ?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setTimestamp(1, Timestamp.valueOf(m.getFechaHora()));
            cs.setString(2, m.getTipoMuestra());
            cs.setInt(3, m.getIdOrden());
            cs.setInt(4, m.getIdTecnico());
            cs.setInt(5,m.getIdPaciente());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR registrar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(TomaMuestra m) {
        String sql = "{CALL sp_actualizar_muestra(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, m.getIdMuestra());
            cs.setTimestamp(2, Timestamp.valueOf(m.getFechaHora()));
            cs.setString(3, m.getTipoMuestra());
            cs.setInt(4, m.getIdOrden());
            cs.setInt(5, m.getIdTecnico());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "{CALL sp_eliminar_muestra(?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR eliminar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public TomaMuestra buscarPorId(int id) {
        String sql = "{CALL sp_buscar_muestra(?)}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                TomaMuestra m = new TomaMuestra();

                m.setIdMuestra(rs.getInt("id_muestra"));
                m.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                m.setTipoMuestra(rs.getString("tipo_muestra"));
                m.setIdOrden(rs.getInt("id_orden"));
                m.setIdTecnico(rs.getInt("id_tecnico"));

                return m;
            }

        } catch (Exception e) {
            System.out.println("ERROR buscarPorId: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<TomaMuestra> listar() {
        List<TomaMuestra> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_muestras()}";

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement cs = conn.prepareCall(sql)) {

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                TomaMuestra m = new TomaMuestra();

                m.setIdMuestra(rs.getInt("id_muestra"));
                m.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                m.setTipoMuestra(rs.getString("tipo_muestra"));
                m.setIdOrden(rs.getInt("id_orden"));
                m.setIdTecnico(rs.getInt("id_tecnico"));
                m.setIdPaciente(rs.getInt("id_paciente"));

                lista.add(m);
            }

        } catch (Exception e) {
            System.out.println("ERROR listar: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public TomaMuestra buscarPorIdOrden(int idOrden) {
            String sql = "{CALL sp_buscar_muestra_por_orden(?)}";

    try (Connection conn = DBConnection.getInstance().getConnection();
         CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idOrden);
        ResultSet rs = cs.executeQuery();

        if (rs.next()) {
            TomaMuestra m = new TomaMuestra();

            m.setIdMuestra(rs.getInt("id_muestra"));
            m.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
            m.setTipoMuestra(rs.getString("tipo_muestra"));
            m.setIdOrden(rs.getInt("id_orden"));
            m.setIdTecnico(rs.getInt("id_tecnico"));
            m.setIdPaciente(rs.getInt("id_paciente"));

            return m;
        }

    } catch (Exception e) {
        System.out.println("ERROR buscarPorIdOrden: " + e.getMessage());
    }

    return null;
    }
}

