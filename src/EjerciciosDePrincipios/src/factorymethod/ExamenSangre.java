/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod;

/**
 *
 * @author KEVIN
 */
public class ExamenSangre extends Examen {
    @Override
    public void procesarMuestra() {
        System.out.println("Procesando muestra de sangre: hematología completa.");
    }
}
