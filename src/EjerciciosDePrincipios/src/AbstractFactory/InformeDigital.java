/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author KEVIN
 */

public class InformeDigital implements Informe {
    @Override
    public void generar() {
        System.out.println("Generando informe digital en formato electrónico (PDF firmado).");
    }
}
