/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class Paciente extends Persona {
    private String email;

    public Paciente(String id, String nombres, String apellidos, String email) {
        super(id, nombres, apellidos);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

