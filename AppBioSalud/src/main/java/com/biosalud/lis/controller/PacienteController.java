/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.controller;

import com.biosalud.lis.dao.impl.PacienteDAOImpl;
import com.biosalud.lis.dao.interfaces.PacienteDAO;
import com.biosalud.lis.dto.PacienteDTO;
import com.biosalud.lis.model.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author folli
 */
public class PacienteController {
    private final PacienteDAO pacienteDAO;
    
    public PacienteController() {
        this.pacienteDAO = new PacienteDAOImpl();
    }
    
    /**
     * Registra un nuevo paciente
     */
    public boolean registrarPaciente(PacienteDTO dto) {
        try {
            // Validaciones
            if (dto.getDni() == null || dto.getDni().trim().isEmpty()) {
                throw new IllegalArgumentException("El DNI es obligatorio");
            }
            if (dto.getNombres() == null || dto.getNombres().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio");
            }
            if (dto.getApellidos() == null || dto.getApellidos().trim().isEmpty()) {
                throw new IllegalArgumentException("El apellido es obligatorio");
            }
            
            // Verificar si el DNI ya existe
            Paciente existente = pacienteDAO.buscarPorDni(dto.getDni());
            if (existente != null) {
                throw new IllegalArgumentException("Ya existe un paciente con ese DNI");
            }
            
            Paciente paciente = dtoToEntity(dto);
            return pacienteDAO.insertar(paciente);
        } catch (Exception e) {
            System.err.println("Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Actualiza los datos de un paciente existente
     */
    public boolean actualizarPaciente(PacienteDTO dto) {
        try {
            if (dto.getIdPaciente() == null) {
                throw new IllegalArgumentException("El ID del paciente es obligatorio para actualizar");
            }
            
            // Validaciones
            if (dto.getDni() == null || dto.getDni().trim().isEmpty()) {
                throw new IllegalArgumentException("El DNI es obligatorio");
            }
            if (dto.getNombres() == null || dto.getNombres().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio");
            }
            if (dto.getApellidos() == null || dto.getApellidos().trim().isEmpty()) {
                throw new IllegalArgumentException("El apellido es obligatorio");
            }
            
            Paciente paciente = dtoToEntity(dto);
            return pacienteDAO.actualizar(paciente);
        } catch (Exception e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Busca un paciente por DNI
     */
    public PacienteDTO buscarPorDni(String dni) {
        try {
            if (dni == null || dni.trim().isEmpty()) {
                throw new IllegalArgumentException("El DNI es obligatorio");
            }
            
            Paciente paciente = pacienteDAO.buscarPorDni(dni);
            return paciente != null ? entityToDto(paciente) : null;
        } catch (Exception e) {
            System.err.println("Error al buscar paciente por DNI: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Busca pacientes por apellidos (búsqueda parcial)
     */
    public List<PacienteDTO> buscarPorApellidos(String apellidos) {
        try {
            if (apellidos == null || apellidos.trim().isEmpty()) {
                throw new IllegalArgumentException("Los apellidos son obligatorios");
            }
            
            List<Paciente> pacientes = pacienteDAO.buscarPorApellidos(apellidos);
            return entitiesToDtos(pacientes);
        } catch (Exception e) {
            System.err.println("Error al buscar pacientes por apellidos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Lista todos los pacientes
     */
    public List<PacienteDTO> listarTodos() {
        try {
            List<Paciente> pacientes = pacienteDAO.listarTodos();
            return entitiesToDtos(pacientes);
        } catch (Exception e) {
            System.err.println("Error al listar pacientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Obtiene el conteo total de pacientes
     */
    public int contarPacientes() {
        try {
            return pacienteDAO.contarPacientes();
        } catch (Exception e) {
            System.err.println("Error al contar pacientes: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Busca un paciente por ID
     */
    public PacienteDTO buscarPorId(Integer id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID es obligatorio");
            }
            
            Paciente paciente = pacienteDAO.buscarPorId(id);
            return paciente != null ? entityToDto(paciente) : null;
        } catch (Exception e) {
            System.err.println("Error al buscar paciente por ID: " + e.getMessage());
            return null;
        }
    }
    
    // Métodos auxiliares de conversión
    private Paciente dtoToEntity(PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(dto.getIdPaciente());
        paciente.setDni(dto.getDni());
        paciente.setNombres(dto.getNombres());
        paciente.setApellidos(dto.getApellidos());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setTelefono(dto.getTelefono());
        paciente.setEmail(dto.getEmail());
        return paciente;
    }
    
    private PacienteDTO entityToDto(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setDni(paciente.getDni());
        dto.setNombres(paciente.getNombres());
        dto.setApellidos(paciente.getApellidos());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setTelefono(paciente.getTelefono());
        dto.setEmail(paciente.getEmail());
        return dto;
    }
    
    private List<PacienteDTO> entitiesToDtos(List<Paciente> pacientes) {
        List<PacienteDTO> dtos = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            dtos.add(entityToDto(paciente));
        }
        return dtos;
    }
}
