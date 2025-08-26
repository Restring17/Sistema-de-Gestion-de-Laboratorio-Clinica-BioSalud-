/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OCP.Ejercicio1;

/**
 *
 * @author folli
 */
public class ServicioNotificaciones {
    private CanalNotificacion canal;

    public ServicioNotificaciones(CanalNotificacion canal) {
        this.canal = canal;
    }
    public void notificar(String mensaje, String destinatario){
        canal.enviar(mensaje, destinatario);
    }
}
