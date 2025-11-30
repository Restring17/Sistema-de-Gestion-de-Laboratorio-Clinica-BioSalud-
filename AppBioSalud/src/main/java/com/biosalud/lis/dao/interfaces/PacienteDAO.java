/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.dao.interfaces;

import com.biosalud.lis.model.Paciente;
import java.util.List;

/**
 *
 * @author folli
 */
public interface PacienteDAO {
    boolean insertar(Paciente paciente);
    boolean actualizar(Paciente paciente);
    boolean eliminar(Integer idPaciente);
    Paciente buscarPorId(Integer idPaciente);
    Paciente buscarPorDni(String dni);
    List<Paciente> buscarPorApellidos(String apellidos);
    List<Paciente> listarTodos();
    int contarPacientes();
}
