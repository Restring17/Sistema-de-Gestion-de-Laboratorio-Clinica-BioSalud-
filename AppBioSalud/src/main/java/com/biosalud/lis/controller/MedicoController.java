package com.biosalud.lis.controller;

import com.biosalud.lis.dao.impl.MedicoDAOImpl;
import com.biosalud.lis.dao.interfaces.MedicoDAO;
import com.biosalud.lis.dto.MedicoDTO;
import com.biosalud.lis.model.Medico;
import java.util.ArrayList;
import java.util.List;

public class MedicoController {

    private final MedicoDAO medicoDAO;

    public MedicoController() {
        this.medicoDAO = new MedicoDAOImpl();
    }

    public boolean registrarMedico(MedicoDTO dto) {
        try {
            if (dto.getNombres() == null || dto.getNombres().trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio");
            }
            if (dto.getApellidos() == null || dto.getApellidos().trim().isEmpty()) {
                throw new IllegalArgumentException("El apellido es obligatorio");
            }
            if (dto.getEspecialidad() == null || dto.getEspecialidad().trim().isEmpty()) {
                throw new IllegalArgumentException("La especialidad es obligatoria");
            }
            if (dto.getCmp() == null || dto.getCmp().trim().isEmpty()) {
                throw new IllegalArgumentException("El CMP es obligatorio");
            }
            if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
                throw new IllegalArgumentException("El teléfono es obligatorio");
            }

            Medico medico = dtoToEntity(dto);
            return medicoDAO.insertar(medico);
        } catch (Exception e) {
            System.err.println("Error al registrar médico: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarMedico(MedicoDTO dto) {
        try {
            if (dto.getId_medico() <= 0) {
                throw new IllegalArgumentException("El ID del médico es obligatorio para actualizar");
            }
            Medico medico = dtoToEntity(dto);
            return medicoDAO.actualizar(medico);
        } catch (Exception e) {
            System.err.println("Error al actualizar médico: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMedico(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID es obligatorio");
            }
            return medicoDAO.eliminar(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar médico: " + e.getMessage());
            return false;
        }
    }

    public MedicoDTO buscarPorId(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("El ID es obligatorio");
            }
            Medico medico = medicoDAO.buscarPorId(id);
            return medico != null ? entityToDto(medico) : null;
        } catch (Exception e) {
            System.err.println("Error al buscar médico por ID: " + e.getMessage());
            return null;
        }
    }

    public List<MedicoDTO> listarTodos() {
        try {
            List<Medico> medicos = medicoDAO.listarTodos();
            return entitiesToDtos(medicos);
        } catch (Exception e) {
            System.err.println("Error al listar médicos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public int contarMedicos() {
        try {
            return medicoDAO.contarMedicos();
        } catch (Exception e) {
            System.err.println("Error al contar médicos: " + e.getMessage());
            return 0;
        }
    }

    private Medico dtoToEntity(MedicoDTO dto) {
        Medico medico = new Medico();
        medico.setIdMedico(dto.getId_medico());
        medico.setNombres(dto.getNombres());
        medico.setApellidos(dto.getApellidos());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setCmp(dto.getCmp());
        medico.setTelefono(dto.getTelefono());
        return medico;
    }

    private MedicoDTO entityToDto(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setId_medico(medico.getIdMedico());
        dto.setNombres(medico.getNombres());
        dto.setApellidos(medico.getApellidos());
        dto.setEspecialidad(medico.getEspecialidad());
        dto.setCmp(medico.getCmp());
        dto.setTelefono(medico.getTelefono());
        return dto;
    }

    private List<MedicoDTO> entitiesToDtos(List<Medico> medicos) {
        List<MedicoDTO> dtos = new ArrayList<>();
        for (Medico medico : medicos) {
            dtos.add(entityToDto(medico));
        }
        return dtos;
    }
}
