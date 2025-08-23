/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
// Clase Paciente
public class Paciente {

    private String idPaciente;
    private String nombres;
    private String apellidos;
    private String email;

    public Paciente(String idPaciente, String nombres, String apellidos, String email) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public String getEmail() {
        return email;
    }
}
