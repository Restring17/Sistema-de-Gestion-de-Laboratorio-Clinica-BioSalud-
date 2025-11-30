package com.biosalud.lis.dto;

public class MedicoDTO {

    private int id_medico;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String cmp;
    private String telefono;

    public MedicoDTO() {
    }

    public MedicoDTO(int id_medico, String nombres, String apellidos, String especialidad, String cmp, String telefono) {
        this.id_medico = id_medico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.cmp = cmp;
        this.telefono = telefono;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
