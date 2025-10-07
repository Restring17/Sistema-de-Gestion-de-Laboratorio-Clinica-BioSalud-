/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author KEVIN
 */
public class ExamenFactoryMethod implements ExamenFactory {
    @Override
    public Examen crearExamen(String tipo) {
        if (tipo.equalsIgnoreCase("sangre")) {
            return new ExamenSangre();
        } else if (tipo.equalsIgnoreCase("orina")) {
            return new ExamenOrina();
        } else {
            throw new IllegalArgumentException("Tipo de examen no reconocido: " + tipo);
        }
    }
}

