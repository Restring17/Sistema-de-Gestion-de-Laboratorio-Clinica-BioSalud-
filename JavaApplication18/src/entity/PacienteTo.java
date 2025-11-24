/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entity;

/**
 * Transfer Object (TO) para Paciente.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Clase simple para transportar datos entre la capa DAO y la Vista.
 *  - SRP: Solo almacena datos del paciente, nada más.
 *  - OCP: Se puede extender sin modificar código existente (añadir campos).
 *  - PROTOTYPE: Puede clonarse fácilmente para manejar versiones del paciente.
 */
public class PacienteTo {

    // Atributos
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String correo;

    // Constructor vacío
    public PacienteTo() {
    }

    // Constructor con parámetros
    public PacienteTo(int idPaciente, String nombre, String apellido, String dni,
                      String telefono, String direccion, String correo) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Getters y Setters

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
