/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorymethod;

/**
 *
 * @author KEVIN
 */

public class Main {
    public static void main(String[] args) {
        ExamenFactory factory = new ExamenFactoryMethod();

        Examen examen1 = factory.crearExamen("sangre");
        examen1.procesarMuestra();

        Examen examen2 = factory.crearExamen("orina");
        examen2.procesarMuestra();
    }
}

