/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biosalud.lis.service.interfaces;

import com.biosalud.lis.model.ResultadoLaboratorio;
import java.util.List;

public interface ResultadoLaboratorioService {

    boolean registrar(ResultadoLaboratorio r);

    boolean actualizar(ResultadoLaboratorio r);

    boolean eliminar(int idResultado);

    ResultadoLaboratorio buscarPorId(int idResultado);

    List<ResultadoLaboratorio> listar();

    boolean validarResultado(int idResultado, boolean validado);
}
