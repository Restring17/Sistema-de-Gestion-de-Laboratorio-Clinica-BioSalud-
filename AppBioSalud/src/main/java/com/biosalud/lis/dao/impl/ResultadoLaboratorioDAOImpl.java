package com.biosalud.lis.dao.impl;

import com.biosalud.lis.dao.interfaces.ResultadoLaboratorioDAO;
import com.biosalud.lis.model.ResultadoLaboratorio;
import com.biosalud.lis.persistence.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultadoLaboratorioDAOImpl implements ResultadoLaboratorioDAO {

    private Connection getConnection() throws SQLException {
        return DBConnection.getInstance().getConnection();
    }

    @Override
    public boolean registrar(ResultadoLaboratorio r) {
        String sql = "{ CALL sp_registrar_resultado(?, ?, ?, ?, ?, ?) }";
        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql)) {

            cs.setTimestamp(1, Timestamp.valueOf(r.getFechaResultado()));
            cs.setString(2, r.getDescripcion());
            cs.setString(3, r.getValoresJson());
            cs.setString(4, r.getConclusiones());
            cs.setInt(5, r.getIdOrden());
            cs.setBoolean(6, r.isValidado());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR registrar resultado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(ResultadoLaboratorio r) {
        String sql = "{ CALL sp_actualizar_resultado(?, ?, ?, ?, ?, ?, ?) }";
        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql)) {

            cs.setInt(1, r.getIdResultado());
            cs.setTimestamp(2, Timestamp.valueOf(r.getFechaResultado()));
            cs.setString(3, r.getDescripcion());
            cs.setString(4, r.getValoresJson());
            cs.setString(5, r.getConclusiones());
            cs.setInt(6, r.getIdOrden());
            cs.setBoolean(7, r.isValidado());

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR actualizar resultado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idResultado) {
        String sql = "{ CALL sp_eliminar_resultado(?) }";
        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql)) {

            cs.setInt(1, idResultado);
            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR eliminar resultado: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ResultadoLaboratorio buscarPorId(int idResultado) {
        String sql = "{ CALL sp_buscar_resultado(?) }";
        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql)) {

            cs.setInt(1, idResultado);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR buscarPorId resultado: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ResultadoLaboratorio> listar() {
        List<ResultadoLaboratorio> lista = new ArrayList<>();
        String sql = "{ CALL sp_listar_resultados() }";

        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                lista.add(mapRow(rs));
            }

        } catch (Exception e) {
            System.out.println("ERROR listar resultados: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean validarResultado(int idResultado, boolean validado) {
        String sql = "{ CALL sp_validar_resultado(?, ?) }";

        try (Connection c = getConnection();
             CallableStatement cs = c.prepareCall(sql)) {

            cs.setInt(1, idResultado);
            cs.setBoolean(2, validado);

            return cs.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ERROR validar resultado: " + e.getMessage());
            return false;
        }
    }

    private ResultadoLaboratorio mapRow(ResultSet rs) throws SQLException {
        ResultadoLaboratorio r = new ResultadoLaboratorio();

        r.setIdResultado(rs.getInt("id_resultado"));

        Timestamp ts = rs.getTimestamp("fecha_resultado");
        if (ts != null) r.setFechaResultado(ts.toLocalDateTime());

        r.setDescripcion(rs.getString("descripcion"));
        r.setValoresJson(rs.getString("valores_json"));
        r.setConclusiones(rs.getString("conclusiones"));
        r.setIdOrden(rs.getInt("id_orden"));
        r.setValidado(rs.getBoolean("validado"));

        return r;
    }
}



