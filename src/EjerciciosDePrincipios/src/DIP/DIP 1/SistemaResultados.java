/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DIP;

/**
 *
 * @author KEVIN
 */
public class SistemaResultados {
    private Notificacion notificacion;

    // Dependencia hacia la abstracción
    public SistemaResultados(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public void publicarResultado(String resultado) {
        System.out.println("Resultado listo: " + resultado);
        notificacion.enviar("Su resultado ya está disponible.");
    }
}

