/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class Medico {

    private String idMedico;
    private String nombres;
    private String especialidad;

    public Medico(String idMedico, String nombres, String especialidad) {
        this.idMedico = idMedico;
        this.nombres = nombres;
        this.especialidad = especialidad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
