package com.biosalud.lis.model;

public class Medico {

    private Integer idMedico;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String cmp;
    private String telefono;

    public Medico() {
    }

    public Medico(Integer idMedico, String nombres, String apellidos, String especialidad, String cmp, String telefono) {
        this.idMedico = idMedico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.cmp = cmp;
        this.telefono = telefono;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
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

    @Override
    public String toString() {
        return "Medico{"
                + "idMedico=" + idMedico
                + ", nombres='" + nombres + '\''
                + ", apellidos='" + apellidos + '\''
                + ", especialidad='" + especialidad + '\''
                + ", cmp='" + cmp + '\''
                + ", telefono='" + telefono + '\''
                + '}';
    }
}
