/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.service.impl;

import com.biosalud.lis.dao.impl.ResultadoLaboratorioDAOImpl;
import com.biosalud.lis.model.ResultadoLaboratorio;
import com.biosalud.lis.service.interfaces.ResultadoLaboratorioService;

import java.util.List;

public class ResultadoLaboratorioServiceImpl implements ResultadoLaboratorioService {

    private final ResultadoLaboratorioDAOImpl dao = new ResultadoLaboratorioDAOImpl();

    @Override
    public boolean registrar(ResultadoLaboratorio r) {
        return dao.registrar(r);
    }

    @Override
    public boolean actualizar(ResultadoLaboratorio r) {
        return dao.actualizar(r);
    }

    @Override
    public boolean eliminar(int idResultado) {
        return dao.eliminar(idResultado);
    }

    @Override
    public ResultadoLaboratorio buscarPorId(int idResultado) {
        return dao.buscarPorId(idResultado);
    }

    @Override
    public List<ResultadoLaboratorio> listar() {
        return dao.listar();
    }

    @Override
    public boolean validarResultado(int idResultado, boolean validado) {
        return dao.validarResultado(idResultado, validado);
    }
}
