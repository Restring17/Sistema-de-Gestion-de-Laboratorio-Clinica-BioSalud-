/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.service.interfaces;

import com.biosalud.lis.model.TomaMuestra;
import java.util.List;

/**
 * PATRÓN UTILIZADO: Service Layer ------------------------------- Define la
 * lógica de negocio para TomaMuestra. No accede directamente a la base de
 * datos.
 *
 * Su objetivo: aislar la lógica para que el controlador no se comunique
 * directamente con el DAO.
 */
public interface TomaMuestraService {

    boolean registrar(TomaMuestra muestra);

    boolean actualizar(TomaMuestra muestra);

    boolean eliminar(int id);

    List<TomaMuestra> listar();
    
    TomaMuestra buscarPorId(int id);
    
    TomaMuestra buscarPorIdOrden(int idOrden);

}

