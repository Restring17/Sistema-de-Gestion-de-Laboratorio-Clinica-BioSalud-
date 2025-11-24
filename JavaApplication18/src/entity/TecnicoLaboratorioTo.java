/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;



/**
 * Transfer Object (TO) para Técnico de Laboratorio.
 *
 * PATRONES Y PRINCIPIOS:
 *  - DTO / TRANSFER OBJECT: Transporta datos entre DAO y Vista (JFrame).
 *  - SRP: Solo representa datos del técnico, sin lógica adicional.
 *  - OCP: Puedes agregar nuevos campos sin romper otras capas.
 *  - PROTOTYPE: Puede clonarse si se requiere gestionar turnos o roles duplicados.
 */
public class TecnicoLaboratorioTo {

    // Atributos
    private int idTecnico;
    private String nombre;
    private String apellido;
    private String dni;
    private String turno;       // Mañana / Tarde / Noche
    private String especialidad; // Ejemplo: Toma de muestras, Bioquímica, Serología
    private String telefono;

    // Constructor vacío
    public TecnicoLaboratorioTo() {
    }

    // Constructor completo
    public TecnicoLaboratorioTo(int idTecnico, String nombre, String apellido, String dni,
                                String turno, String especialidad, String telefono) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.turno = turno;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    // Getters y Setters

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
