/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OCP.Ejercicio1;

/**
 *
 * @author folli
 */
public class NotificacionEmail implements CanalNotificacion {

    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando EMAIL a " + destinatario + ": " + mensaje);
    }
}
