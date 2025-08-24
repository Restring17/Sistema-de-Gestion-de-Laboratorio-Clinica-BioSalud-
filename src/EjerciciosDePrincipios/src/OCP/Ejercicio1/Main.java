/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package1;

/**
 *
 * @author folli
 */
public class Main {
    public static void main(String[] args) {
        //Notificacion por Email
        ServicioNotificaciones emailNotificacion = new ServicioNotificaciones(new NotificacionEmail());
        emailNotificacion.notificar("Aqui tiene su resultado de laboratorio", "correopaciente.gmail.com");
        
        //Notifcacion por SMS
        ServicioNotificaciones smsNotificacion = new ServicioNotificaciones(new NotificacionSMS());
        smsNotificacion.notificar("Aqui tiene su resultado de laboratorio", "+957715766");
    }
}
