/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DIP;

/**
 *
 * @author KEVIN
 */
public class Main {
    public static void main(String[] args) {
        // Usando email
        SistemaResultados sistemaEmail = new SistemaResultados(new NotificacionEmail());
        sistemaEmail.publicarResultado("Glucosa: 95 mg/dl");

        // Usando SMS
        SistemaResultados sistemaSMS = new SistemaResultados(new NotificacionSMS());
        sistemaSMS.publicarResultado("Hemoglobina: 14 g/dl");
    }
}

