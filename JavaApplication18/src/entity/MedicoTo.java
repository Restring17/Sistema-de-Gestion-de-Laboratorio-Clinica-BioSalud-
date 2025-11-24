/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 * Transfer Object (TO) para Medico.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Transporta datos entre la capa DAO y la Vista.
 *  - SRP: Solo almacena información del médico.
 *  - OCP: Se puede extender sin modificar el funcionamiento actual.
 *  - PROTOTYPE: Se puede clonar si necesitas duplicar configuraciones de médicos.
 */
public class MedicoTo {

    // Atributos
    private int idMedico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String cmp;          // Código médico profesional
    private String telefono;
    private String correo;

    // Constructor vacío
    public MedicoTo() {
    }

    // Constructor completo
    public MedicoTo(int idMedico, String nombre, String apellido, String especialidad,
                    String cmp, String telefono, String correo) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.cmp = cmp;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y Setters

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
