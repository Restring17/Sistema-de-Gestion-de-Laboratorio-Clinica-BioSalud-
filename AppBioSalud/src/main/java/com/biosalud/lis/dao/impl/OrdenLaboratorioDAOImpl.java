package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.OrdenLaboratorioDAO;
import com.biosalud.lis.model.OrdenLaboratorio;
import com.biosalud.lis.persistence.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdenLaboratorioDAOImpl implements OrdenLaboratorioDAO {

    @Override
    public int save(OrdenLaboratorio orden) throws Exception {
        String sql = "{CALL sp_insertar_orden_laboratorio(?,?,?,?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setTimestamp(1, new Timestamp(orden.getFechaOrden().getTime()));
            stmt.setString(2, orden.getTipoExamen());
            stmt.setString(3, orden.getObservaciones());
            stmt.setInt(4, orden.getIdPaciente());
            stmt.setInt(5, orden.getIdMedico());
            boolean hasResult = stmt.execute();
            if (hasResult) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        int id = rs.getInt("id_orden");
                        orden.setIdOrden(id);
                        return id;
                    }
                }
            }
            return -1;
        }
    }

    @Override
    public Optional<OrdenLaboratorio> findById(int id) throws Exception {
        String sql = "{CALL sp_buscar_orden_laboratorio(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    OrdenLaboratorio o = mapRow(rs);
                    return Optional.of(o);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(OrdenLaboratorio orden) throws Exception {
        String sql = "{CALL sp_actualizar_orden_laboratorio(?,?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, orden.getIdOrden());
            stmt.setTimestamp(2, new Timestamp(orden.getFechaOrden().getTime()));
            stmt.setString(3, orden.getTipoExamen());
            stmt.setString(4, orden.getObservaciones());
            stmt.setInt(5, orden.getIdPaciente());
            stmt.setInt(6, orden.getIdMedico());
            stmt.setString(7, orden.getEstado());
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "{CALL sp_eliminar_orden_laboratorio(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
    }

    @Override
    public List<OrdenLaboratorio> listAll() throws Exception {
        String sql = "{CALL sp_listar_ordenes_laboratorio()}";
        List<OrdenLaboratorio> lista = new ArrayList<>();

        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapRow(rs));
            }
        }
        return lista;
    }

    @Override
    public List<OrdenLaboratorio> listByDateRange(Date inicio, Date fin)
            throws Exception {
        String sql = "{CALL sp_ordenes_por_rango_fechas(?,?)}";
        List<OrdenLaboratorio> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setDate(1, inicio);
            stmt.setDate(2, fin);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapRow(rs));
                }
            }
        }
        return lista;
    }

    @Override
    public boolean changeState(int idOrden, String estado) throws Exception {
        String sql = "{CALL sp_cambiar_estado_orden(?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idOrden);
            stmt.setString(2, estado);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
    }

    private OrdenLaboratorio mapRow(ResultSet rs) throws SQLException {
        OrdenLaboratorio o = new OrdenLaboratorio();
        o.setIdOrden(rs.getInt("id_orden"));
        Timestamp ts = rs.getTimestamp("fecha_orden");
        if (ts != null) {
            o.setFechaOrden(new java.sql.Date(ts.getTime()));
        }
        o.setTipoExamen(rs.getString("tipo_examen"));
        o.setObservaciones(rs.getString("observaciones"));
        o.setIdPaciente(rs.getInt("id_paciente"));
        o.setIdMedico(rs.getInt("id_medico"));
        o.setEstado(rs.getString("estado"));
        return o;
    }

}
